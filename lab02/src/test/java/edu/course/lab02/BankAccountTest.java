package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testSuccessfulWithdrawal() {
        // Создаем счет с балансом 1000
        BankAccount account = new BankAccount(1000);
        
        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void testWithdrawExceedsBalanceThrowsException() {
        BankAccount account = new BankAccount(500);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600);
        });
    }
}

