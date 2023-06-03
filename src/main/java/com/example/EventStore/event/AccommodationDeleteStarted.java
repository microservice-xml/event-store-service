package com.example.EventStore.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "events")
public class AccommodationDeleteStarted extends BaseEvent{

    @Field
    List<Long> accommodationIds;

    public AccommodationDeleteStarted() {}

    public AccommodationDeleteStarted(String id, LocalDateTime timestamp, EventType type, List<Long> accommodationIds) {
        super(id, timestamp, type);
        this.accommodationIds = accommodationIds;
    }
}
