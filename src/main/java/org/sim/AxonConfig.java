package org.sim;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    @Bean
    public Serializer serializer() {
        return JsonSerializer.builder().build();
    }

    @Bean
    public EventStore eventStore() {
        return EmbeddedEventStore.builder().storageEngine(new org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine()).build();
    }
}