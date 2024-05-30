package com.example.demo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Producer {

    private final Disruptor disruptor;

    /**
     * 发送数据
     *
     * @param data
     */
    public void send(String data) {
        RingBuffer<Message> ringBuffer = disruptor.getRingBuffer();
        long next = ringBuffer.next();
        try {
            Message message = ringBuffer.get(next);
            message.setData(data);
        } finally {
            ringBuffer.publish(next);
        }
    }

}
