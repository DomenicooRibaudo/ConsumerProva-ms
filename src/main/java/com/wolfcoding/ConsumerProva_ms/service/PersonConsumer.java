package com.wolfcoding.ConsumerProva_ms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wolfcoding.ConsumerProva_ms.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class PersonConsumer implements MessageListener {
    private static final String QUEUE_PERSON = "test.person";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private Gson gson;

    private static final Logger logger = LoggerFactory.getLogger(PersonConsumer.class);

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();

                Person person = gson.fromJson(text, Person.class);
//                String personJson = gson.toJson(person);
                logger.info("Oggetto Person ricevuto dalla coda: {}", objectMapper.writeValueAsString(person));
                logger.info("Oggetto non convertito:" + person);
            } else {
                logger.error("Messaggio ricevuto non è di tipo TextMessage.");
            }
        } catch (Exception e) {
            logger.error("Errore nella deserializzazione del messaggio: {}", e.getMessage());
        }
    }
}

