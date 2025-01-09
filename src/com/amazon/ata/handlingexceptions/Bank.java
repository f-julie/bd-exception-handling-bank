package com.amazon.ata.handlingexceptions;

import java.math.BigDecimal;

import com.amazon.ata.handlingexceptions.exceptions.InsufficientFundsException;
import com.amazon.ata.handlingexceptions.exceptions.InvalidInputException;
import com.amazon.ata.handlingexceptions.exceptions.TransactionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class represents a bank, which includes the functionality to transfer from
 * one BankAccount to another.
 */
public class Bank {
    private Logger log = LogManager.getLogger(Bank.class);

    /**
     * Transfer money from one account to another. 
     * 
     * @param fromAccount BankAccount to withdraw amount from
     * @param toAccount BankAccount to deposit amount into
     * @param amount of money to transfer.
     * @return true if transfer was successful, false if transfer fails due to insufficient funds
     */
    public boolean transfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) throws TransactionException {
        // TODO: implement
        try {
            // Withdraw the amount from the fromAccount
            fromAccount.withdraw(amount);
            // Deposit the amount to the toAccount
            toAccount.deposit(amount);
            // If no exceptions were thrown, the transfer was successful
            return true;
        } catch (InsufficientFundsException e) {
            // Log the exception and return false
            log.error("Transfer failed due to insufficient funds: " + e.getMessage());
            return false;
        } catch (InvalidInputException e) {
            // Log the exception and propagate it
            log.error("Transfer failed due to invalid input: " + e.getMessage());
            throw e;
        } catch (TransactionException e) {
            // Log the exception and propagate it as a RuntimeException
            log.error("Transfer failed due to a transaction error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
