package org.sim.events;

import java.time.Instant;

public abstract class CultEvent {
    private String cultId;
    private Instant timestamp;

    public CultEvent() {}

    public CultEvent(String cultId) {
        this.cultId = cultId;
        this.timestamp = Instant.now();
    }

    public String getCultId() {
        return cultId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}