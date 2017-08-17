package ru.lebedev.javalearn.vladykin.Concurrency.lockdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    private final Lock lock = new ReentrantLock();
    private final Condition balanceIncreased = lock.newCondition();

    private long balance;

    public Account() {this.balance = 0L; }

    public Account(long balance){
        this.balance = balance;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(long m){
        checkNegativeAmount(balance);
        lock.lock();
        try{
            balance += m;
            balanceIncreased.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(long m){
        checkNegativeAmount(balance);
        lock.lock();
        try {
            if (m > balance) {
                throw new IllegalArgumentException("Can't withdraw " + m + ", balance is " + balance);
            }
                balance -= m;
        } finally {
            lock.unlock();
        }
    }

    public void waitAndWithdraw(long amount) throws InterruptedException {
        checkNegativeAmount(balance);
        lock.lock();
        try {
            while (balance < amount) {
                balanceIncreased.await();
            }
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }


    public void checkNegativeAmount(long amount) {
        if (amount < 0){
            throw new IllegalArgumentException("negative amount");
        }
    }
}
