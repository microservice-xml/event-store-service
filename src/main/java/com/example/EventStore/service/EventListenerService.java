package com.example.EventStore.service;

import com.example.EventStore.event.*;
import com.example.EventStore.repository.EventRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventListenerService {

    private final EventRepository eventRepository;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {"myQueue"})
    public void consume(String message){
        try {
            BaseEvent baseEvent = objectMapper.readValue(message, BaseEvent.class);
            saveObject(message, baseEvent.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveObject(String jsonMessage, EventType type) throws JsonProcessingException, JsonMappingException {
        System.out.println("Received message: " + jsonMessage.toString());
        switch (type) {
            case DELETE_USER_STARTED -> {
                UserDeleteStarted startedEvent = objectMapper.readValue(jsonMessage, UserDeleteStarted.class);
                eventRepository.save(startedEvent);
            }
            case DELETE_ACCOMMODATION_FAILED -> {
                AccommodationDeleteFailed deleteAccommodationEvent = objectMapper.readValue(jsonMessage, AccommodationDeleteFailed.class);
                eventRepository.save(deleteAccommodationEvent);
            }
            case DELETE_SLOT_FAILED -> {
                SlotsDeleteFailed slotsFailedEvent = objectMapper.readValue(jsonMessage, SlotsDeleteFailed.class);
                eventRepository.save(slotsFailedEvent);
            }
            case DELETE_ACCOMMODATION_STARTED -> {
                AccommodationDeleteStarted delAccStartedEvent = objectMapper.readValue(jsonMessage, AccommodationDeleteStarted.class);
                eventRepository.save(delAccStartedEvent);
            }
            case SLOTS_DELETED, ACCOMMODATION_DELETED -> {
                BaseEvent baseEvent = objectMapper.readValue(jsonMessage, BaseEvent.class);
                eventRepository.save(baseEvent);
            }
            default -> {
            }
        }
    }
}
