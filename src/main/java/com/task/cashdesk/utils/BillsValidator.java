package com.task.cashdesk.utils;

import com.task.cashdesk.exceptions.WrongTotalAmountToBillsException;
import com.task.cashdesk.models.dto.CashDTO;

public class BillsValidator {
    public static void validate(CashDTO cashDTO) {
        int billsTotalValue =
                (cashDTO.getOnes() * 1)
                        + (cashDTO.getFives() * 5)
                        + (cashDTO.getTens() * 10)
                        + (cashDTO.getTwenties() * 20)
                        + (cashDTO.getFifties() * 50)
                        + (cashDTO.getHundreds() * 100);
        if (cashDTO.getAmount() > billsTotalValue) {
            throw new WrongTotalAmountToBillsException("Total amount requested exceeds the total value of bills");
        }
        if(cashDTO.getAmount() < billsTotalValue){
            throw new WrongTotalAmountToBillsException("Total amount requested is less than the total value of bills");
        }

    }
}
