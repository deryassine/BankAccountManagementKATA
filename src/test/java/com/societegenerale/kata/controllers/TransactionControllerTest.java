package com.societegenerale.kata.controllers;

import com.societegenerale.kata.entities.Transaction;
import com.societegenerale.kata.services.TransactionsManagementService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Collections;

@SpringBootTest
/** The transaction controller test
 * @author Yassine D
 */
public class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;
    private Transaction transaction = new Transaction("", "", 0, null);
    @Mock
    private TransactionsManagementService transactionsManagementService;

    /**
     * method to test the deposit into an account from the API
     * @throws IOException
     */
    @Test
    public void should_deposit_into_account() throws IOException {
        transaction.setBalance(10);
        Mockito.when(transactionsManagementService.depositIntoAccount("Yassine D", 10)).thenReturn(transaction);
        Assertions.assertThat(transactionController.depositIntoAccount("Yassine D", 10)).isEqualTo(transaction);
    }

    /**
     * method to test the withdrawal from an account from the API
     * @throws IOException
     */
    @Test
    public void should_withdraw_from_account() throws IOException {
        transaction.setBalance(-10);
        Mockito.when(transactionsManagementService.withdrawFromAccount("Yassine D", 10)).thenReturn(transaction);
        Assertions.assertThat(transactionController.withdrawFromAccount("Yassine D", 10)).isEqualTo(transaction);
    }

    /**
     * method to test the view of all the transactions history from the API
     * @throws IOException
     */
    @Test
    public void should_view_transaction_history(){
        Assertions.assertThat(transactionController.transactionsHistories()).isEqualTo(Collections.emptyList());
    }

}
