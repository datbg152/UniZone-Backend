package com.unizone.chatservice.controller;

import com.unizone.chatservice.dto.ChatDTO;
import com.unizone.chatservice.service.ChatService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ChatController {

    @Autowired
    private ChatService chatService; // Gọi service để xử lý gửi tin nhắn

    @MessageMapping("/chat")
    @SendTo("/topic/chat") // Đưa kết quả tin nhắn ra cho tất cả các client đăng ký với /topic/chat
    public ChatDTO sendMessage(ChatDTO chatDTO) {
        // Gọi service để gửi tin nhắn
        return chatService.sendMessage(chatDTO);
    }
}