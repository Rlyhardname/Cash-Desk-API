package com.task.cashdesk.models.dto;

import com.task.cashdesk.models.entity.Cash;
import com.task.cashdesk.models.entity.Cashier;
import com.task.cashdesk.businesslogic.CashDesk;

import java.util.Map;
import java.util.Set;

public class CashDeskDTO {
    public Set<String> availableCurrencies;
    private Map<String, Cash> currencyAmountsMap;
    private Cashier cashier;

    public CashDeskDTO(CashDesk cashDesk) {
        this.availableCurrencies = cashDesk.getAvailableCurrencies();
        this.currencyAmountsMap = cashDesk.getCurrencyAmountsMap();
        this.cashier = cashDesk.getCashier();
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
