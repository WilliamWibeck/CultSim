package org.sim;

import java.util.Random;

public class Cult {
    public String name;
    public String leaderName;
    public int followerCount;
    public double leaderCharismaLevel;
    public double fearLevel;
    public boolean active;

    public Cult (String name, String leaderName, int followerCount, double leaderCharismaLevel, double fearLevel){
        this.name = name;
        this.leaderName = leaderName;
        this.followerCount = followerCount;
        this.leaderCharismaLevel = leaderCharismaLevel;
        this.fearLevel = fearLevel;
        this.active = true;
    }

    public void recruitFollowers() {

        Random rand = new Random();

        double randomInt = rand.nextDouble() * 10;

        int newFollowers = (int) Math.round(this.leaderCharismaLevel * randomInt);

        if(newFollowers > this.leaderCharismaLevel){
            this.followerCount += newFollowers;
            if(leaderCharismaLevel < 10 && newFollowers > followerCount / 10){
                this.fearLevel = fearLevel * 0.95;
                this.leaderCharismaLevel = leaderCharismaLevel * 1.1;
                System.out.println(this.leaderName + " gains the support of his followers");
                if(this.leaderCharismaLevel >= 10) {
                    this.leaderCharismaLevel = 10;
                }

                if(this.fearLevel < 0) {
                    this.fearLevel = 0;
                }
            }

            System.out.println("The cult of " + this.name + " has recruited " + newFollowers + " followers" + " Total: " + this.followerCount);
        }else {
            System.out.println("The cult of " + this.name + " has not grown.");
        }
    }
    public void loseFollowers() {

        Random rand = new Random();

        double randomDouble = rand.nextDouble() * 10;

        int lostFollowers = (int) Math.round((this.fearLevel * randomDouble) - (this.leaderCharismaLevel * 1.8));

        if(this.followerCount > 0) {
            if(lostFollowers > this.fearLevel){
                this.followerCount -= lostFollowers;

                if(followerCount < 0){
                    followerCount = 0;
                    this.active = false;
                }

                if(lostFollowers > followerCount / 20){
                    this.fearLevel = fearLevel * 1.1;
                    this.leaderCharismaLevel = leaderCharismaLevel * 0.95;
                }
                System.out.println("The cult of " + this.name + " has lost " + lostFollowers + " followers" + " Total: " + this.followerCount);
            }
        } else {
            System.out.println("The cult of " + this.name + " has collapsed");
        }
    }

    public void loseOrGainFollowers() {
        Random rand = new Random();

        if(this.fearLevel > 8 || this.leaderCharismaLevel < 5) {
            loseFollowers();
        }

        else if(this.leaderCharismaLevel > 5 && this.fearLevel <= 7) {
            recruitFollowers();
        }

        else {
            int randomInt = rand.nextInt(100);
            if(randomInt > 85){
                loseFollowers();
            }
        }




    }

    public void takeTurn(){
        if(this.active){
        loseOrGainFollowers();
        }

    }


}
