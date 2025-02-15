package org.sim;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cult scienthologyCult = new Cult("Scienthology", "Tom Cruise", 902, 8.2, 7.6 );
        Cult churchOfFierySkies = new Cult("Church of fiery skies", "Jesus", 524, 9.5, 1.4);
        Cult doomsdayBelievers = new Cult("Doomsday Believers", "Aubrey Plaza", 209, 4.6, 10.0);
        Cult scarletCrusade = new Cult("The Scarlet Crusade", "Alexander Mograine", 2012, 8.8, 5.6);

        ArrayList<Cult> cults = new ArrayList<>();

        cults.add(scienthologyCult);
        cults.add(churchOfFierySkies);
        cults.add(doomsdayBelievers);
        cults.add(scarletCrusade);

        for (int i = 1; i <= 10; i++) {
            System.out.println("\n Turn: " + "[" + i + "]");
            cults.stream().forEach(Cult::takeTurn);
        }
    }
}