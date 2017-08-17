package ru.lebedev.javalearn.vladykin.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static int nextInt() {
        return counter.getAndIncrement();
    }

    ;

    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; ++j) nextInt();
            });
            thread.start();
            threads.add(thread);

        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final counter is: " + counter);


    }
}
