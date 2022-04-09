package com.example.streams.modifications;

import java.util.stream.IntStream;

public class ThreadExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
           IntStream.range(0, 10000).forEach(
                i-> System.out.println(Thread.currentThread().getId() + ":" +i));
        };
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
