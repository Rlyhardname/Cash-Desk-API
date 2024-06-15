package com.task.cashdesk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/cash-balance")
public class CashBalanceController {
    @GetMapping("")
    void loadIndex(){

    }

}
