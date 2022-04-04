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
}