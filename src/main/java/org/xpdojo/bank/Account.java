package org.xpdojo.bank;

public class Account {
    private int balance;

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if(amount < balance) {
            balance -= amount;
        }
    }

    public void transfer(int amount, Account targetAccount) {
        if(amount < balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
        }
    }
}
