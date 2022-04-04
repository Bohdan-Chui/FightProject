package com.project.model.impl;

public class Knight extends Warrior {

    private static int attack = 7;

    public Knight() {
        super(50);
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
