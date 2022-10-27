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

    public static int CanSpawnHere(LinkedList<BadCar> badCars) {
        int canSpawnHere = -1;
        int i = 0;
        while (canSpawnHere == -1 && i < badCars.size()) {
            int j = 0;
            while (canSpawnHere == -1 && j < badCars.size()) {
                if (badCars.get(i).getHitbox().intersects(badCars.get(j).getHitbox())) canSpawnHere = i;
                j++;
            }
            i++;
        }
        return canSpawnHere;
    }

}