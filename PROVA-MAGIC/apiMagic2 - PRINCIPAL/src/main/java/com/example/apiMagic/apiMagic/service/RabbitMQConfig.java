package com.example.apiMagic.apiMagic.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue notificationQueue() {
        return new Queue("notificationQueue", true);
    }

    @Bean
    public Queue deckImportQueue() {
        return new Queue("deck_import_queue", true);
    }

    @Bean
    public Queue deckUpdatesQueue() {
        return new Queue("deck_updates_queue", true);
    }
}