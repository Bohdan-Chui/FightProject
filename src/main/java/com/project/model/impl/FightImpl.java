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
            enemy2.damage(enemy1.attack());
            if (!enemy2.isAlive())
                return true;

            enemy1.damage(enemy2.attack());
            if (!enemy1.isAlive())
                return false;
        }
    }


}
