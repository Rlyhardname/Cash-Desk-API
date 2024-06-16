package com.task.cashdesk.services;

import com.task.cashdesk.businesslogic.CashDesk;
import com.task.cashdesk.models.dto.CashDeskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashBalanceService {
    private final CashDesk cashDesk;

    @Autowired
    public CashBalanceService(CashDesk cashDesk) {
        this.cashDesk = cashDesk;
    }

    public CashDeskDTO getBalance() {
        return cashDesk.getBalance();
    }
}
