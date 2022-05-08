package com.project.model;

import com.project.model.army.impl.Army;
import com.project.model.army.impl.Solder;

import java.util.Iterator;

public class Fight {

    public static boolean duel(Fightable enemy1, Fightable enemy2) {
        if (!enemy1.isAlive())
            return false;
        if (!enemy2.isAlive())
            return true;

        while (true) {
            enemy1.hit(enemy2);
            if (!enemy2.isAlive())
                return true;

            enemy2.hit(enemy1);
            if (!enemy1.isAlive())
                return false;
        }
    }

    public static boolean battle(Army army1, Army army2) {
        army1.prepareArmy();
        army2.prepareArmy();
        do {
            army1.moveUnits();
            army2.moveUnits();
            Fightable warrior1 = army1.getAliveFighter();
            Fightable warrior2 = army2.getAliveFighter();
            if (warrior1 == null)
                return false;
            if (warrior2 == null)
                return true;
            duel(warrior1, warrior2);
        } while (true);
    }

    public static boolean straightFight(Army army1, Army army2) {

        Iterator<Solder> it1 = army1.getIterator();
        Iterator<Solder> it2 = army2.getIterator();

        while (it1.hasNext() && it2.hasNext()) {
            duel(it1.next(), it2.next());
        }

        army1.filterArmyFromDied();
        army2.filterArmyFromDied();

        if (army1.size() == 0) {
            return false;
        }
        if (army2.size() == 0) {
            return true;
        }

        return straightFight(army1, army2);
    }
}
