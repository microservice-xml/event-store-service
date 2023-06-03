package com.example.EventStore.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "events")
public class SlotsDeleteFailed extends BaseEvent{

    @Field
    List<Long> accommodationIds;

    public SlotsDeleteFailed() {}
}
