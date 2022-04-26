package com.project.model.enemy;

public class Lancer extends Warrior {
    private static final int ATTACK = 6;
    private static final int START_HEALTH = 50;
    private static final int DAMAGE_DIVIDER = 2;

    public Lancer() {
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
    public int doDamage(Warrior warrior) {
        int damage = warrior.takeDamage(this.getAttack());
        if (warrior.getSoldierBehind() != null)
            warrior.getSoldierBehind().takeDamage(damage / DAMAGE_DIVIDER);
        return damage;
    }
}
