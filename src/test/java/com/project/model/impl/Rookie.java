package com.project.model.impl;

class Rookie extends Warrior {
    private static final int ATTACK = 1;

    public Rookie() {
        super(50);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
