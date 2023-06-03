package com.example.EventStore.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "events")
public class AccommodationDeleteFailed extends BaseEvent{

    @Field
    private Long userId;

    public AccommodationDeleteFailed() {}
}
