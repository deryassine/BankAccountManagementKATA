package com.societegenerale.kata.services;

import com.societegenerale.kata.entities.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.util.List;

@SpringBootTest
/**
 * @author Yassine D
 */
public class TransactionsManagementServiceTest {

    @InjectMocks
    private TransactionsManagementService transactionsManagementService;
    private String fullName = "Yassine D";
    private float amount = 10;

    /**
     * method to test the deposit into an account
     * @throws IOException
     */
    @Test
    public void should_deposit_into_account() throws IOException {
        Transaction transaction = transactionsManagementService.depositIntoAccount(fullName, amount);
        Assertions.assertThat(transaction.getFullName()).isEqualTo("Yassine D");
        Assertions.assertThat(transaction.getBalance()).isEqualTo(10);
        Assertions.assertThat(transaction.getOperation()).isEqualTo("Deposit Money");
    }

    /**
     * method to test the withdrawal from an account
     * @throws IOException
     */
    @Test
    public void should_withdrawFromAccount() throws IOException {
        Transaction transaction = transactionsManagementService.withdrawFromAccount(fullName, amount);
        Assertions.assertThat(transaction.getFullName()).isEqualTo("Yassine D");
        Assertions.assertThat(transaction.getBalance()).isEqualTo(-10);
        Assertions.assertThat(transaction.getOperation()).isEqualTo("Withdraw Money");
    }

    /**
     * method to test the view of all the transactions history
     * @throws IOException
     */
    @Test
    public void should_view_no_transaction_history() {
        List<Transaction> transaction = transactionsManagementService.viewTransactionHistory();
        Assertions.assertThat(transaction).isNotNull();
        Assertions.assertThat(transaction).isEmpty();
    }

}
