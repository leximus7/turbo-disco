package ru.lebedev.javalearn.vladykin.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreTest1 {
    private static Semaphore semaphore = new Semaphore(2, true);



    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; ++i){
            Thread thread = new TestThread(semaphore);

            threads.add(thread);
            thread.start();
        }
        Thread.sleep(20000L);

        for (Thread thread : threads){
            thread.interrupt();
        }


    }

    private static class TestThread extends Thread {
        private final Semaphore semaphore;

        private TestThread(Semaphore semaphore) {this.semaphore = semaphore;}

        @Override
        public void run() {
            try {
                unsafeRun();
            } catch (InterruptedException e){
                System.out.println(getName() + " interrupted");
            }

        }

        public void unsafeRun() throws InterruptedException{
            for (; ; ) {
                semaphore.acquire();
                try {

                    System.out.println(getName() + " acquired semaphore");
                    sleep(5000L);

                } finally {
                    System.out.println(getName() + " releasing semaphore");
                    semaphore.release();

                }
            }

        }



    }
}
