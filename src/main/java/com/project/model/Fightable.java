package com.project.model;


import com.project.model.weapon.Weapon;

public interface Fightable {

    int hit(Fightable enemy);

    int getDamage(int damage);

    int getAttack();

    boolean isAlive();

    void equipWeapon(Weapon weapon);

}
