package com.example.apiMagic.apiMagic.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DeckImportWorker {

    @Autowired
    private ProducerService producerService;

    @RabbitListener(queues = "deck_import_queue")
    public void importDeck(String deckDetails) {
        System.out.println("Iniciando a importação do baralho: " + deckDetails);

        String updateMessage = "Importação do baralho concluída: " + deckDetails;
        producerService.sendDeckUpdate(updateMessage);  
    }
}
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckWorkerService {

    @Autowired
    private DeckStatusService deckStatusService;

    @Autowired
    private DeckUpdateService deckUpdateService;

    public void importDeck(String deckDetails, String deckId) {
        // Atualiza o status para "Processando importação"
        deckStatusService.updateDeckStatus(deckId, "Processando importação");

        System.out.println("Iniciando importação do baralho: " + deckDetails);

        // Processamento simulado do baralho (validação, integração, etc.)
        // Adicione aqui a lógica de importação

        // Atualiza o status para "Importação concluída"
        deckStatusService.updateDeckStatus(deckId, "Importação concluída");

        // Envia atualização após a conclusão
        deckUpdateService.sendDeckUpdate("Importação do baralho concluída: " + deckDetails);
    }
}*/