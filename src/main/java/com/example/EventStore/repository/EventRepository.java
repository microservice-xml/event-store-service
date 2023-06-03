package com.example.EventStore.repository;

import com.example.EventStore.event.BaseEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<BaseEvent, String> {
}
