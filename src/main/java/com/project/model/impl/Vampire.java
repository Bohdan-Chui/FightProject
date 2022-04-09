package com.project.model.impl;

public class Vampire extends Warrior {

    private static final int ATTACK = 4;
    private static final int START_HEALTH = 40;
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(START_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int doDamage(Warrior warrior) {
        int damage = warrior.takeDamage(this.getAttack());
        this.setHelth(getHealth() + damage * VAMPIRISM / 100);
        if(getHealth() > START_HEALTH)
            this.setHelth(START_HEALTH);
        return damage;
    }
}
