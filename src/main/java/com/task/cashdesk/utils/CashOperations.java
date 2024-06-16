package com.task.cashdesk.utils;

import com.task.cashdesk.exceptions.messages.ValidationMessages;
import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.businesslogic.CashDesk;

public class CashOperations {
        public static void executeOperation(CashDTO cashDTO, CashDesk cashDesk){
            String operation = cashDTO.getOperation();
            switch (operation){
                case "deposit": cashDesk.deposit(cashDTO); break;
                case "withdraw": cashDesk.withdraw(cashDTO); break;
                default: throw new UnsupportedOperationException(ValidationMessages.UNSUPPORTED_OPERATION);
            }
        }
}
