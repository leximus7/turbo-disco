package ru.lebedev.javalearn.vladykin.Concurrency;

public class ChangeAccount {
    public static void main(String[] args) throws Exception {
        Account account = new Account(100000);
        System.out.println("begin balance = " + account.getBalance());

        Thread withdraw = new WithdrawThread(account);
        Thread deposit = new DepositThread(account);
        withdraw.start();
        deposit.start();

        withdraw.join();
        deposit.join();

        System.out.println("End balance = " + account.getBalance());
    }

    private static class WithdrawThread extends Thread {
        private final Account account;

        private WithdrawThread(Account account) {this.account = account;}

        @Override
        public void run(){
            for(int i = 0; i < 20000; ++i){
                account.withdraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        private DepositThread(Account account) {this.account = account;}

        @Override
        public void run(){
            for(int i = 0; i < 20000; ++i){
                account.deposit(1);
            }
        }
    }


}
