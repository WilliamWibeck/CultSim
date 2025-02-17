package org.sim;

import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.sim.events.FollowersJoinedEvent;

import java.util.Random;

public class Cult {
    private final String id;
    private final String name;
    private int followerCount;
    private final EventBus eventBus;

    public Cult (String id, String name, int followerCount, EventBus eventBus){
        this.id = id;
        this.name = name;
        this.followerCount = followerCount;
        this.eventBus = eventBus;
    }

    public void recruitFollowers() {
        Random rand = new Random();
        int newFollowers = rand.nextInt(50) + 1;

        eventBus.publish(GenericEventMessage.asEventMessage(new FollowersJoinedEvent(id, newFollowers)));

        System.out.println("The cult of " + name + " recruited " + newFollowers + " followers!   ");
    }



}
