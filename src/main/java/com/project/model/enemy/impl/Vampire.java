package com.project.model.enemy.impl;

import com.project.model.enemy.Enemy;
import com.project.model.Fightable;

public class Vampire extends Enemy {

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    @Override
    public int hit(Fightable enemy) {

        int getDamage = enemy.getDamage(attack);
        this.health += getDamage * VAMPIRISM / 100;

        if (health > startHealth)
            health = startHealth;

        return getDamage;
    }
}
