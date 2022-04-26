package com.project.model.enemy;

public class Healer extends Warrior {
    private static final int ATTACK = 0;
    private static final int START_HEALTH = 60;
    private static final int HEAL = 2;

    public Healer() {
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

    public void heal(Warrior warrior) {
        warrior.setHelth(Math.min(warrior.getStartHealth(), warrior.getHealth() + HEAL));
    }
}
