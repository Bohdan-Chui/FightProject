package com.project.model.impl;

import com.project.model.Fight;

public class FightImpl implements Fight {
    @Override
    public boolean fight(Warrior enemy1, Warrior enemy2) {

        if (!enemy1.isAlive())
            return false;
        if (!enemy2.isAlive())
            return true;

        while (true) {
            enemy1.doDamage(enemy2);
            if (!enemy2.isAlive())
                return true;

            enemy2.doDamage(enemy1);
            if (!enemy1.isAlive())
                return false;
        }
    }


}
