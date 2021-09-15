package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

public class AccountTest {

    @Test
    public void initialAccountBalanceIsZero() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountToIncreaseAccountBalance() {
        Account account = new Account();
        account.deposit(100);
        assertThat(account.balance()).isEqualTo(100);
    }

    @Test
    public void depositSeveralAmountsToIncreaseAccountBalance() {
        Account account = new Account();
        account.deposit(100);
        account.deposit(300);
        assertThat(account.balance()).isEqualTo(400);
    }

    @Test
    public void withdrawZeroAmountNotAffectsAccountBalance() {
        Account account = new Account();
        account.withdraw(0);
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void withdrawAmountToDecreaseAccountBalanceHavingFunds() {
        Account account = new Account();
        account.deposit(200);
        account.withdraw(100);
        assertThat(account.balance()).isEqualTo(100);
    }

    @Test
    public void withdrawAmountFromAccountWithoutEnoughFundsNotAffectsBalance() {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(200);
        assertThat(account.balance()).isEqualTo(100);
    }
}
