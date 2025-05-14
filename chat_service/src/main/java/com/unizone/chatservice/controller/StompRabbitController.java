package com.unizone.chatservice.controller;

import com.unizone.chatservice.dto.ChatDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Controller
public class StompRabbitController {

    private final SimpMessagingTemplate messagingTemplate;

    public StompRabbitController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat-direct")
    public void sendDirect(@Payload ChatDTO chatDTO) {
        // Ví dụ: gửi đến queue chỉ định của người nhận
        String destination = "/exchange/chat.direct.exchange/user.message";
        messagingTemplate.convertAndSend(destination, chatDTO);
    }

    // Sau này có thể thêm method cho group chat tại đây
}
