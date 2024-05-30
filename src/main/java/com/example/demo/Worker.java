package com.example.demo;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Worker implements WorkHandler<Message>, EventHandler<Message> {

    private final Integer number;

    @Override
    public void onEvent(Message message) throws Exception {
        System.out.println("Consumer No." + number + " :" + message);
    }


    @Override
    public void onEvent(Message message, long l, boolean b) throws Exception {
        System.out.println("Consumer No." + number + " :" + message);
    }
}
