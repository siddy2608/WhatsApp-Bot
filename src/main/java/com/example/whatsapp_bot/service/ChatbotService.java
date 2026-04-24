package com.example.whatsapp_bot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    public String getReply(String message) {
        if (message == null || message.trim().isEmpty()) {
            return "Message cannot be empty.";
        }

        String normalized = message.trim().toLowerCase();

        switch (normalized) {
            case "hi":
                return "Hello";
            case "bye":
                return "Goodbye";
            default:
                return "I did not understand that.";
        }
    }
}