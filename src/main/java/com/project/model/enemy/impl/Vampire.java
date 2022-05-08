package com.project.model.enemy.impl;

import com.project.model.enemy.Enemy;
import com.project.model.Fightable;
import com.project.model.weapon.Weapon;

public class Vampire extends Enemy {

    private  int vampirism = 50;

    public Vampire() {
        super(40, 4);
    }

    @Override
    public int hit(Fightable enemy) {

        int getDamage = enemy.getDamage(attack);
        this.health += getDamage * vampirism / 100;

        if (health > startHealth)
            health = startHealth;

        return getDamage;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.startHealth = Math.max(0, startHealth + weapon.getHealth());
        this.health = Math.max(0, health + weapon.getHealth());
        this.attack = Math.max(0, attack + weapon.getAttack());
        this.vampirism =  Math.max(0, vampirism + weapon.getVampirism());
    }

}
