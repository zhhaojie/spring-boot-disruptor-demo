package com.example.demo;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Worker worker1 = new Worker(1);
        Worker worker2 = new Worker(2);

        Disruptor<Message> disruptor = new Disruptor<>(Message::new, 1024, Executors.defaultThreadFactory());

        // 两者不消费重复的任务
        disruptor.handleEventsWithWorkerPool(worker1, worker2);
        disruptor.start();

        Producer producer = new Producer(disruptor);
        for (int i = 0; i < 1000; i++) {
            producer.send("xx" + i);
        }

    }
}
