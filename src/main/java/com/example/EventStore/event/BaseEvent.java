package com.example.EventStore.event;

import jdk.jfr.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "events")
@Builder
public class BaseEvent {

    @Id
    private String id;

    @Field
    private LocalDateTime timestamp;

    @Field
    private EventType type;
}
