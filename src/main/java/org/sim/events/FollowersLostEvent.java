package org.sim.events;

public class FollowersLostEvent extends CultEvent {

    private final int numberOfFollowers;

    public FollowersLostEvent(String cultId, int numberOfFollowers) {
        super(cultId);
        this.numberOfFollowers = numberOfFollowers;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

}
