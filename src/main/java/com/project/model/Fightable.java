package com.project.model;


public interface Fightable {

    int hit(Fightable enemy);

    int getDamage(int damage);

    int getAttack();

    boolean isAlive();

}
