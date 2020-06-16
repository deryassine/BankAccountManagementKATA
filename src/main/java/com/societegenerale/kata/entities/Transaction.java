package com.societegenerale.kata.entities;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
/**
 * the transaction model
 * @author Yassine D
 * @param fullName The first name and the last name of an account holder
 * @param operation The operation type
 * @param balance The current balance of an account
 * @param date The date of a transaction
 */
public class Transaction {

    private String fullName;
    private String operation;
    private float balance;
    private Date date;
}
