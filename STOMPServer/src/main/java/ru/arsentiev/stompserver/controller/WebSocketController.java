package ru.arsentiev.stompserver.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/hello") // Обрабатывает сообщения с клиента по адресу "/app/hello"
    @SendTo("/topic/greetings") // Отправляет сообщения всем подписчикам "/topic/greetings"
    public String sendGreeting(String message) {
        return "Hello, " + message + "!";
    }
}
