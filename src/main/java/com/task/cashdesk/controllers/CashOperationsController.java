package com.task.cashdesk.controllers;

import com.task.cashdesk.exceptions.DuplicateOperationException;
import com.task.cashdesk.exceptions.LackOfBillsException;
import com.task.cashdesk.exceptions.WrongTotalAmountToBillsException;
import com.task.cashdesk.models.dto.CashDTO;
import com.task.cashdesk.services.CashService;
import com.task.cashdesk.utils.ApiKeyValidator;
import com.task.cashdesk.utils.BillsValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.task.cashdesk.exceptions.messages.ValidationMessages.DUPLICATE_OPERATION;
import static com.task.cashdesk.exceptions.messages.ValidationMessages.NOT_ENOUGH_BILLS;

@RestController
@RequestMapping("/api/v1/cash-operations/")
public class CashOperationsController {

    private final CashService cashService;


    @Autowired
    public CashOperationsController(CashService cashService) {
        this.cashService = cashService;
    }

    @PostMapping("")
    ResponseEntity<String> depositOrWithdraw(@RequestHeader() String apiKey,
                                             @Valid @RequestBody CashDTO cashDTO) {
        if (!ApiKeyValidator.isValid(apiKey)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            BillsValidator.validate(cashDTO);
            cashService.executeOperation(cashDTO);
        } catch (WrongTotalAmountToBillsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (DuplicateOperationException e) {
            return new ResponseEntity<>(String.format(DUPLICATE_OPERATION, cashDTO.getReferenceNumber()), HttpStatus.BAD_REQUEST);
        } catch (LackOfBillsException e) {
            return new ResponseEntity<>(String.format(NOT_ENOUGH_BILLS, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("successful operation", HttpStatus.ACCEPTED);
    }

}