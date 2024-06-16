package com.task.cashdesk.validator;

import com.task.cashdesk.exceptions.LackOfBillsException;
import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.models.entity.Cash;

public class PositiveInt {
    private int amount;
    private int ones;
    private int fives;
    private int tens;
    private int twenties;
    private int fifties;
    private int hundreds;

    public void tryAddBills(CashDTO cashDTO, Cash cash) {
        amount = cash.getAmount() + cashDTO.getAmount();
        ones = cash.getOnes() + cashDTO.getOnes();
        fives = cash.getFives() + cashDTO.getFives();
        tens = cash.getTens() + cashDTO.getTens();
        twenties = cash.getTwenties() + cashDTO.getTwenties();
        fifties = cash.getFifties() + cashDTO.getFifties();
        hundreds = cash.getHundreds() + cashDTO.getHundreds();

        boolean tooManyBillsOfAKind = amount > 100000
                || ones > 5000
                || fives > 2000
                || tens > 1000
                || twenties > 1000
                || fifties > 750
                || hundreds > 500;
        if(tooManyBillsOfAKind){
            notifyHigherUps();
        }

    }

    private void notifyHigherUps(){
        // send notification...
    }

    public void trySubtractBills(CashDTO cashDTO, Cash cash) {
        amount = cash.getAmount() - cashDTO.getAmount();
        ones = cash.getOnes() - cashDTO.getOnes();
        fives = cash.getFives() - cashDTO.getFives();
        tens = cash.getTens() - cashDTO.getTens();
        twenties = cash.getTwenties() - cashDTO.getTwenties();
        fifties = cash.getFifties() - cashDTO.getFifties();
        hundreds = cash.getHundreds() - cashDTO.getHundreds();

        areBillsEnough();
    }

    private void areBillsEnough() {
        StringBuilder sb = new StringBuilder();
        if (amount < 0) {
            sb.append("(cashier doesn't have enough money in total)");
        }
        if (ones < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("1");
        }
        if (fives < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("5");
        }
        if (tens < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("10");
        }
        if (twenties < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("20");
        }
        if (fifties < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("50");
        }
        if (hundreds < 0) {
            if (!sb.isEmpty()) {
                sb.append(",");
            }
            sb.append("100");
        }

        if (!sb.isEmpty()) {
            throw new LackOfBillsException(sb.toString());
        }

    }

    public int getAmount() {
        return amount;
    }

    public int getOnes() {
        return ones;
    }

    public int getFives() {
        return fives;
    }

    public int getTens() {
        return tens;
    }

    public int getTwenties() {
        return twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public int getHundreds() {
        return hundreds;
    }
}
