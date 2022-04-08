package com.project.model.impl;

public class Warrior {

    private static int attack = 5;
    private int health;


    public Warrior() {
        this(50);
    }

    protected Warrior(int i) {
        this.health = i;
    }

    public int attack() {
        return getAttack();
    }

    public int getAttack() {
        return attack;
    }

    public void damage(int damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public static Warrior getUnit(Class<? extends Warrior> clazz) {
        if (clazz == Warrior.class)
            return new Warrior();
        if (clazz == Knight.class)
            return new Knight();
        if (clazz == Defender.class)
            return new Defender();
        throw new NoClassDefFoundError("no such class");
    }
}