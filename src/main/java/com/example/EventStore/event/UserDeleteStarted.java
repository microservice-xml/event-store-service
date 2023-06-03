package com.example.EventStore.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Document(collection = "events")
public class UserDeleteStarted extends BaseEvent {

    @Field
    private Long userId;

    public UserDeleteStarted() {}
}
