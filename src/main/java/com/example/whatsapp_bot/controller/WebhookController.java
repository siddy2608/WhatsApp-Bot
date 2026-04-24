package com.example.whatsapp_bot.controller;

import com.example.whatsapp_bot.dto.WhatsappMessageRequest;
import com.example.whatsapp_bot.dto.WhatsappMessageResponse;
import com.example.whatsapp_bot.service.ChatbotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final ChatbotService chatbotService;

    public WebhookController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping
    public ResponseEntity<WhatsappMessageResponse> receiveMessage(
            @RequestBody WhatsappMessageRequest request) {

        logger.info("Received message from {}: {}", request.getFrom(), request.getMessage());

        String reply = chatbotService.getReply(request.getMessage());

        WhatsappMessageResponse response = new WhatsappMessageResponse(reply);
        return ResponseEntity.ok(response);
    }
}