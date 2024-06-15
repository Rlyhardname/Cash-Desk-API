package com.task.cashdesk.models.entity;

public class Cashier {
    private String name;
    private int numOfDailyDeposits;
    private int numOfDailyWithdraws;

    public Cashier(String name) {
        this.name = name;
    }

    public void incrementDailyDeposits() {
        numOfDailyDeposits++;
    }

    public void incrementDailyWithdraws() {
        numOfDailyWithdraws++;
    }

    public void deposit() {

    }

    public void withdraw() {

    }

    public boolean hasMadeDepositWithdrawRequirements() {
        return numOfDailyWithdraws > 1 && numOfDailyDeposits > 1;
    }

    public String getName() {
        return name;
    }

    public int getNumOfDailyDeposits() {
        return numOfDailyDeposits;
    }

    public int getNumOfDailyWithdraws() {
        return numOfDailyWithdraws;
    }
}
