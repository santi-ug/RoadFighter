package utils;

import entities.BadCar;
import entities.Player;

import java.util.LinkedList;

public class HelpMethods {

    public static boolean CanMoveHere(Player p, LinkedList<BadCar> badCars) {
        boolean canMoveHere = true;
        int i = 0;
        while (canMoveHere && i < badCars.size()) {
            if (p.getHitbox().intersects(badCars.get(i).getHitbox())) canMoveHere = false;
            i++;
        }
        return canMoveHere;
    }

}