package com.task.cashdesk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cash-operations")
public class CashOperationsController {

    @GetMapping("")
    void loadIndex(){

    }

}