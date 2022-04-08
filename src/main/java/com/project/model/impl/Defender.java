package com.project.model.impl;

public class Defender extends Warrior{
    private static int attack = 3;
    private static int defence = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void damage(int damage) {
        if(damage > defence){
            super.damage(damage - defence);
        }
    }
}
