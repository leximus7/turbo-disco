package ru.lebedev.javalearn.vladykin.Concurrency;

public class Account {
    private long balance;

    public Account(long balance){
        this.balance = balance;
    }

    public void deposit(long m){
        checkNegativeAmount(balance);
        synchronized (this){
            balance += m;
        }
    }

    public void withdraw(long m){
        checkNegativeAmount(balance);
        if (m > balance){
            throw new IllegalArgumentException("Can't withdraw " + m + ", balance is " + balance);
        }
        synchronized (this) {
            balance -= m;
        }
    }

    public long getBalance() {
        return balance;
    }

    public void checkNegativeAmount(long amount) {
        if (amount < 0){
            throw new IllegalArgumentException("negative amount");
        }
    }
}
