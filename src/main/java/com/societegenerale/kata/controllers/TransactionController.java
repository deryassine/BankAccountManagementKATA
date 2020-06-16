package com.societegenerale.kata.controllers;

import com.societegenerale.kata.entities.Transaction;
import com.societegenerale.kata.services.TransactionsManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
/**
 * The transaction controller
 * @author Yassine D
 */
public class TransactionController {
    private TransactionsManagementService transactionsManagementService = new TransactionsManagementService();

    /**
     * API Method that let a user deposit into an account
     * @param fullName Full name of an account holder
     * @param amount the amount to deposit
     * @return The transaction
     * @throws IOException
     */
    @GetMapping("/depositIntoAccount/{fullName}/{amount}")
    public Transaction depositIntoAccount(@PathVariable String fullName, @PathVariable float amount) throws IOException {
            return transactionsManagementService.depositIntoAccount(fullName, amount);

    }

    /**
     * API Method that let a user withdraw into an account
     * @param fullName Full name of an account holder
     * @param amount the amount to withdraw
     * @return The transaction
     * @throws IOException
     */
    @GetMapping("/withdrawFromAccount/{fullName}/{amount}")
    public Transaction withdrawFromAccount(@PathVariable String fullName, @PathVariable float amount) throws IOException {
            return transactionsManagementService.withdrawFromAccount(fullName, amount);
    }

    /**
     * API the show all the transactions history
     * @return The list of all the transactions
     */
    @GetMapping("/transactionHistory")
    public List<Transaction> transactionsHistories() {
        return transactionsManagementService.viewTransactionHistory();
    }
}
