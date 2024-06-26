package com.task.cashdesk.controllers;

import com.task.cashdesk.exceptions.DailyDepositAndWithDrawRequirementsNotMetException;
import com.task.cashdesk.services.CashBalanceService;
import com.task.cashdesk.utils.ApiKeyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cash-balance")
public class CashBalanceController {

    private final CashBalanceService cashBalanceService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public CashBalanceController(CashBalanceService cashBalanceService) {
        this.cashBalanceService = cashBalanceService;
    }

    @PostMapping("")
    public ResponseEntity<?> getBalance(@RequestHeader() String apiKey) {
        if (!ApiKeyValidator.isValid(apiKey)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            return new ResponseEntity<>(cashBalanceService.getBalance(), HttpStatus.OK);
        } catch (DailyDepositAndWithDrawRequirementsNotMetException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
