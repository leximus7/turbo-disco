package ru.lebedev.javalearn.vladykin.Concurrency.lockdemo;

public class LockDemo {

    public static void main(String[] args) throws Exception {
        Account account = new Account(0);

        new DepositThread(account).start();

        System.out.println("withdraw...");
        account.waitAndWithdraw(50000000);
        System.out.println("withdraw finidhed. Account balance is " + account.getBalance());

    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) { this.account = account; }

        @Override
        public void run(){
            for (int i = 0; i < 60000000; ++i){
                account.deposit(1);
            }
        }

    }


}
