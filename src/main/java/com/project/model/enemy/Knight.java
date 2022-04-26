package com.project.model.enemy;

public class Knight extends Warrior {

    private static final int ATTACK = 7;
    private static final int START_HEALTH = 50;

    public Knight() {
        super(START_HEALTH);
    }
    @Override
    public int getStartHealth() {
        return START_HEALTH;
    }
    @Override
    public int getAttack() {
        return ATTACK;
    }
}
