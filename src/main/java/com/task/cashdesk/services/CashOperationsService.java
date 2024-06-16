package com.task.cashdesk.services;

import com.task.cashdesk.businesslogic.CashDesk;
import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.utils.CashOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashOperationsService {
    private final CashDesk cashDesk;

    @Autowired
    public CashOperationsService(CashDesk cashDesk) {
        this.cashDesk = cashDesk;
    }

    public void executeOperation(CashDTO cashDTO) {
        CashOperations.executeOperation(cashDTO, cashDesk);
    }
}
