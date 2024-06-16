package com.task.cashdesk.models.entity;

import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.validator.PositiveInt;

public class Cash {
    private final String threeLetterCurrencyCode;
    private int amount;
    private int ones;
    private int fives;
    private int tens;
    private int twenties;
    private int fifties;
    private int hundreds;

    public Cash(String threeLetterCurrencyCode, int amount) {
        this.threeLetterCurrencyCode = threeLetterCurrencyCode;
        this.amount = amount;
    }

    public void combineCash(CashDTO cashDTO) {
        PositiveInt positiveInt = new PositiveInt();
        if (cashDTO.getOperation().equals("deposit")) {
            positiveInt.tryAddBills(cashDTO, this);
        } else if (cashDTO.getOperation().equals("withdraw")) {
            positiveInt.trySubtractBills(cashDTO, this);
        }

        finalizeCashCombine(positiveInt);
    }

    public void finalizeCashCombine(PositiveInt positiveInt) {
        amount = positiveInt.getAmount();
        ones = positiveInt.getOnes();
        fives = positiveInt.getFives();
        tens = positiveInt.getTens();
        twenties = positiveInt.getTwenties();
        fifties = positiveInt.getFifties();
        hundreds = positiveInt.getHundreds();
    }

    public String getThreeLetterCurrencyCode() {
        return threeLetterCurrencyCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOnes() {
        return ones;
    }

    public void setOnes(int ones) {
        this.ones = ones;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public int getTens() {
        return tens;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public int getTwenties() {
        return twenties;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "threeLetterCurrencyCode='" + threeLetterCurrencyCode + '\'' +
                ", amount=" + amount +
                ", ones=" + ones +
                ", fives=" + fives +
                ", tens=" + tens +
                ", twenties=" + twenties +
                ", fifties=" + fifties +
                ", hundreds=" + hundreds +
                '}';
    }
}
