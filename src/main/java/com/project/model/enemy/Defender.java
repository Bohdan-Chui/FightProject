package com.project.model.enemy;

public class Defender extends Warrior {
    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;
    private static final int START_HEALTH = 60;

    public Defender() {
        super(START_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int getStartHealth() {
        return START_HEALTH;
    }
    @Override
    public int takeDamage(int damage) {
        if (damage > DEFENCE) {
            super.takeDamage(damage - DEFENCE);
        }
        return damage - DEFENCE;
    }
}
