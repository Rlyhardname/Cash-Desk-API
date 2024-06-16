package com.task.cashdesk.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class CashDTO {
    @NotEmpty
    private String referenceNumber;
    @NotEmpty(message = "invalid operation")
    private String operation;
    @NotEmpty
    private String date;
    @NotEmpty(message = "invalid country code")
    @Size(min = 3, max = 3, message = "invalid country code")
    private String threeLetterCurrencyCode;
    @NotEmpty
    private Integer amount;
    @Min(value = 0)
    private Integer ones;
    @Min(0)
    private Integer fives;
    @Min(0)
    private Integer tens;
    @Min(0)
    private Integer twenties;
    @Min(0)
    private Integer fifties;
    @Min(0)
    private Integer hundreds;

    public @NotEmpty String getReferenceNumber() {
        return referenceNumber;
    }

    public @NotEmpty(message = "invalid operation") String getOperation() {
        return operation;
    }

    public @NotEmpty(message = "invalid country code") @Size(min = 3, max = 3, message = "invalid country code") String getThreeLetterCurrencyCode() {
        return threeLetterCurrencyCode;
    }

    public @NotEmpty Integer getAmount() {
        return amount;
    }

    public @Min(value = 0) Integer getOnes() {
        return ones;
    }

    public @Min(0) Integer getFives() {
        return fives;
    }

    public @Min(0) Integer getTens() {
        return tens;
    }

    public @Min(0) Integer getTwenties() {
        return twenties;
    }

    public @Min(0) Integer getFifties() {
        return fifties;
    }

    public @Min(0) Integer getHundreds() {
        return hundreds;
    }

    public @NotEmpty String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CashDTO{" +
                "referenceNumber='" + referenceNumber + '\'' +
                ", operation='" + operation + '\'' +
                ", date='" + date + '\'' +
                ", threeLetterCurrencyCode='" + threeLetterCurrencyCode + '\'' +
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
