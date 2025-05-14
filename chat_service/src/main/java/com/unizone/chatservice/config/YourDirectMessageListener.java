package com.unizone.chatservice.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class YourDirectMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String msgContent = new String(message.getBody());
        System.out.println("[Direct] Received: " + msgContent);

        // TODO: Thêm xử lý logic cho tin nhắn point-to-point tại đây
    }
}