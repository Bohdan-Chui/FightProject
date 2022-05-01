package com.project.model.enemy;

import com.project.model.Fightable;

public abstract class Enemy implements Fightable {

    protected int startHealth;
    protected int attack;
    protected int health;


    protected Enemy(int startHealth, int attack) {
        this.startHealth = startHealth;
        this.health = startHealth;
        this.attack = attack;
    }

    public int getDamage(int damage) {
        health -= damage;
        return damage;
    }

    @Override
    public int hit(Fightable enemy) {
        return enemy.getDamage(this.getAttack());
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void healMe(int healing) {
        health = Math.min(startHealth, health + healing);
    }

}
