package com.project.model.impl;

public class Warrior {

    private static final int ATTACK = 5;
    private static final int START_HEALTH = 50;
    private Warrior soldierBehind;
    private int health;

    public Warrior() {
        this(START_HEALTH);
    }

    protected Warrior(int i) {
        this.health = i;
    }

    public int attack() {
        return getAttack();
    }

    public int getAttack() {
        return ATTACK;
    }

    public int takeDamage(int damage) {
        this.health -= damage;
        return damage;
    }

    public int doDamage(Warrior warrior) {
        return warrior.takeDamage(this.attack());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    protected void setHelth(int health) {
        this.health = health;
    }

    protected Warrior getSoldierBehind() {
        return soldierBehind;
    }

    protected void setSoldierBehind(Warrior soldierBehind) {
        this.soldierBehind = soldierBehind;
    }

    public static Warrior getUnit(Class<? extends Warrior> clazz) {
        if (clazz == Warrior.class)
            return new Warrior();
        if (clazz == Knight.class)
            return new Knight();
        if (clazz == Defender.class)
            return new Defender();
        if (clazz == Vampire.class)
            return new Vampire();
        if (clazz == Lancen.class)
            return new Lancen();
        throw new NoClassDefFoundError("no such class");
    }
}