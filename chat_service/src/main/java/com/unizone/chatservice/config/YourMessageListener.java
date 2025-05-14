package com.unizone.chatservice.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class YourMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        // Xử lý tin nhắn
        System.out.println("Received message: " + new String(message.getBody()));
        // Thực hiện các hành động cần thiết với tin nhắn
    }
}