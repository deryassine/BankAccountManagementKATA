package com.societegenerale.kata.services;

import com.societegenerale.kata.entities.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
/**
 * The transaction service management
 * @author Yassine D
 */
public class TransactionsManagementService {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private List<Transaction> transactions = new ArrayList<>();
    private Transaction transaction = new Transaction();
    private static final String SAVING_MONEY = "Withdraw Money";
    private static final String DEPOSIT_MONEY = "Deposit Money";

    /**
     * The method that let deposit into an account
     *
     * @param fullName The full name of an account holder
     * @param amount   Amount to be deposit into account
     * @return The transaction
     * @throws IOException
     */
    public Transaction depositIntoAccount(String fullName, float amount) {
        transaction.setFullName(fullName);
        transaction.setOperation(DEPOSIT_MONEY);
        transaction.setBalance(transaction.getBalance() + amount);
        transaction.setDate(Calendar.getInstance().getTime());
        saveTransactionHistory(transaction);

        log.info("Account status >> ** First Name & Last Name: {} || Operation : {} ||  Balance : {} || date : {} "
                , transaction.getFullName(), transaction.getOperation(), transaction.getBalance(), transaction.getDate());
        return transaction;
    }

    /**
     * The method that let withdraw from an account
     *
     * @param fullName The full name of an account holder
     * @param amount   Amount to withdraw from an account
     * @return The transaction
     * @throws IOException
     */
    public Transaction withdrawFromAccount(String fullName, float amount) {
        transaction.setFullName(fullName);
        transaction.setOperation(SAVING_MONEY);
        transaction.setBalance(transaction.getBalance() - amount);
        transaction.setDate(Calendar.getInstance().getTime());
        saveTransactionHistory(transaction);
        log.info("Account status >> ** First Name & Last Name: {} || Operation : {} ||  Balance : {} || date : {} "
                , transaction.getFullName(), transaction.getOperation(), transaction.getBalance(), transaction.getDate());

        return transaction;
    }

    /**
     * Save the transaction to history
     *
     * @param transaction the Transaction that will be added to history
     */
    public void saveTransactionHistory(Transaction transaction) {
        Transaction transactionToSave = new Transaction(transaction.getFullName(), transaction.getOperation(), transaction.getBalance(), transaction.getDate());
        transactions.add(transactionToSave);

        log.info("Saving transaction history...");
    }

    /**
     * View all the transactions history
     *
     * @return The list of all transactions
     */
    public List<Transaction> viewTransactionHistory() {
        return transactions;
    }
}
