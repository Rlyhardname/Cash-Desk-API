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

    public boolean hasMadeDepositAndWithdrawRequirements() {
        return numOfDailyWithdraws > 1 && numOfDailyDeposits > 1;
    }

    public String getRequirementsQuota() {
        int deposits = 0;
        int withdraws = 0;
        if (numOfDailyDeposits < 2) {
            deposits = 2 - numOfDailyDeposits;
        }
        if (numOfDailyWithdraws < 2) {
            withdraws = 2 - numOfDailyWithdraws;
        }

        return "CashDesk requires " + deposits + " more deposits and " + withdraws + " more withdraws before balance check is available";
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
