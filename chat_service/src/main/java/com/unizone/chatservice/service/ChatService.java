package com.unizone.chatservice.service;

import com.unizone.chatservice.dto.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
@Service
public class ChatService {

    @Autowired
    private RabbitTemplate rabbitTemplate;  // RabbitTemplate được inject từ RabbitConfig

    private static final String DIRECT_ROUTING_KEY = "user.message";  // Routing key cho point-to-point

    // Phương thức gửi tin nhắn
    public ChatDTO sendMessage(ChatDTO chatDTO) {
        // Gửi tin nhắn tới RabbitMQ qua exchange và routing key đã cấu hình trong RabbitConfig
        rabbitTemplate.convertAndSend("chat.direct.exchange", DIRECT_ROUTING_KEY, chatDTO);

        // Trả lại tin nhắn để gửi cho client
        return chatDTO;
    }

    // Phương thức nhận tin nhắn (nếu cần thiết cho xử lý)
    public void receiveMessage(ChatDTO chatDTO) {
        // Logic xử lý tin nhắn khi nhận từ RabbitMQ
        System.out.println("Received message: " + chatDTO);
    }
}