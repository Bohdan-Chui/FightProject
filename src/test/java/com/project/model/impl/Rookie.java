package com.project.model.impl;

class Rookie extends  Warrior{
    private static int attack = 1;

    public Rookie() {
        super(50);
    }

    @Override
    public int getAttack() {
        return attack;
    }
}
