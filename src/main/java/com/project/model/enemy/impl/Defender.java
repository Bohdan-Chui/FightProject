package com.project.model.enemy.impl;

import com.project.model.enemy.Enemy;

public class Defender extends Enemy {

    private static final int DEFENCE = 2;

    public Defender() {
        super(60, 3);
    }

    @Override
    public int getDamage(int damage) {
        if (damage > DEFENCE) {
            health -= (damage - DEFENCE);
        }
        return damage - DEFENCE;
    }
}
