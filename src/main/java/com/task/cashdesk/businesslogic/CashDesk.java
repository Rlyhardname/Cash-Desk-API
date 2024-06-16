package com.task.cashdesk.businesslogic;

import com.task.cashdesk.exceptions.DailyDepositAndWithDrawRequirementsNotMetException;
import com.task.cashdesk.exceptions.UnsupportedCurrencyException;
import com.task.cashdesk.exceptions.messages.ValidationMessages;
import com.task.cashdesk.io.utils.Reader;
import com.task.cashdesk.io.utils.Writer;
import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.models.dto.CashDeskDTO;
import com.task.cashdesk.models.entity.Cash;
import com.task.cashdesk.models.entity.Cashier;
import com.task.cashdesk.utils.ReferenceValidator;

import java.nio.file.NoSuchFileException;
import java.util.*;

public class CashDesk {
    public Set<String> availableCurrencies;
    private Map<String, Cash> currencyAmountsMap;
    private Cashier cashier;

    public CashDesk(Cashier cashier) {
        defaultCurrencies();
        newDayConfigurations(cashier);
    }

    private void defaultCurrencies() {
        availableCurrencies = new HashSet<>();
        availableCurrencies.add("BGN");
        availableCurrencies.add("EUR");
    }

    private void newDayConfigurations(Cashier cashier) {
        currencyAmountsMap = new HashMap<>();
        this.cashier = cashier;
        defaultDailyConfiguration();
    }

    private void defaultDailyConfiguration() {
        Cash bgn = new Cash("BGN", 1000);
        bgn.setTens(50);
        bgn.setFifties(10);
        validateCurrency(bgn.getThreeLetterCurrencyCode());
        currencyAmountsMap.put(bgn.getThreeLetterCurrencyCode(), bgn);

        Cash euro = new Cash("EUR", 2000);
        euro.setTens(100);
        euro.setFifties(20);
        validateCurrency(euro.getThreeLetterCurrencyCode());
        currencyAmountsMap.put(euro.getThreeLetterCurrencyCode(), euro);

    }

    private void validateCurrency(String threeLetterCurrencyCode) throws UnsupportedCurrencyException {
        if (!isCurrencyAvailable(threeLetterCurrencyCode)) {
            throw new UnsupportedCurrencyException(String.format(ValidationMessages.UNSUPPORTED_CURRENCY, threeLetterCurrencyCode));
        }
    }

    private boolean isCurrencyAvailable(String codeName) {
        return availableCurrencies.contains(codeName);
    }

    public void deposit(CashDTO cashDTO) {
        // potential extra validations..
        executeOperationProtocol(cashDTO);
    }

    private void executeOperationProtocol(CashDTO cashDTO) {
        try {
            validateRequest(cashDTO);
        } catch (NoSuchFileException ignored) {

        }

        checkCashAvailabilityAndExecuteOperation(cashDTO);

        cashOperationToFileSystem(cashDTO);

        printCurrencies();
    }

    private void printCurrencies() {
        for (Map.Entry<String, Cash> entry : currencyAmountsMap.entrySet()) {
            System.out.println("currency code: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }


    private void validateRequest(CashDTO cashDTO) throws NoSuchFileException {
        List<String> lines = Reader.readTxtReturnRerordsList(cashDTO.getDate(), cashDTO.getOperation());
        if (Objects.nonNull(lines)) {
            ReferenceValidator.checkForRecordDuplication(lines, cashDTO.getReferenceNumber());
        }
    }

    private void checkCashAvailabilityAndExecuteOperation(CashDTO cashDTO) {
        Cash cashInCurrency = currencyAmountsMap.get(cashDTO.getThreeLetterCurrencyCode());
        cashInCurrency.combineCash(cashDTO);
    }

    public void withdraw(CashDTO cashDTO) {
        // potential extra validations..
        executeOperationProtocol(cashDTO);
    }

    private void cashOperationToFileSystem(CashDTO cashDTO) {
        final String threeLetterCurrencyCodeCode = cashDTO.getThreeLetterCurrencyCode();
        validateCurrency(threeLetterCurrencyCodeCode);
        final String operation = cashDTO.getOperation();

        if (operation.equals("deposit")) {
            cashier.incrementDailyDeposits();
        }
        if (operation.equals("withdraw")) {
            cashier.incrementDailyWithdraws();
        }

        List<String> lines = null;
        try {
            lines = Reader.readTxtReturnRerordsList(cashDTO.getDate(), operation);

            if (Objects.nonNull(lines)) {
                ReferenceValidator.checkForRecordDuplication(lines, cashDTO.getReferenceNumber());
                Writer.writeDepositToTxt(cashDTO, operation);
            }
        } catch (NoSuchFileException e) {
            // log(e)
            System.err.println("files doesn't exist");
            Writer.writeDepositToTxt(cashDTO, operation);
        }
    }

    public CashDeskDTO getBalance() {
        if (cashier.hasMadeDepositAndWithdrawRequirements()) {
            return new CashDeskDTO(this);
        }

        throw new DailyDepositAndWithDrawRequirementsNotMetException(cashier.getRequirementsQuota());
    }

    public Set<String> getAvailableCurrencies() {
        return availableCurrencies;
    }

    public Map<String, Cash> getCurrencyAmountsMap() {
        return currencyAmountsMap;
    }

    public Cashier getCashier() {
        return cashier;
    }
}