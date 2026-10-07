package edu.course.lab02;

public class BankAccount {
    
    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        
        this.balance = initialBalance; 
    }

    // Единственный легальный способ узнать, сколько денег на счету (геттер)
    public int getBalance() {
        return this.balance;
    }

        public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        
        this.balance += amount; 
    }

    public void withdraw(int amount) {
        if (amount <=0) {
            throw new IllegalArgumentException ("Сумма снятия должна быть положительной");
        }
        
        if (amount > this.balance) {
            throw new IllegalArgumentException ("Недостаточно средств на счете");
        }
        this.balance -= amount; 
    }

}
