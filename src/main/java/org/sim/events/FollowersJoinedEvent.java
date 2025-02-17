package org.sim.events;

public class FollowersJoinedEvent extends CultEvent{

    private final int numberOfFollowers;

    public FollowersJoinedEvent(String cultId, int numberOfFollowers) {
        super(cultId);
        this.numberOfFollowers = numberOfFollowers;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

}
