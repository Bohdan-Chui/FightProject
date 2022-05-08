package com.project.model.enemy.impl;

import com.project.model.army.ValueEnum;
import com.project.model.enemy.Enemy;
import com.project.model.weapon.Weapon;

public class Warlord extends Enemy {

    private int defence = 2;

    public Warlord() {
        super(100, 4);
    }

    @Override
    public int getDamage(int damage) {
        if (damage > defence) {
            health -= (damage - defence);
        }
        return damage - defence;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.startHealth = Math.max(0, startHealth + weapon.getHealth());
        this.health = Math.max(0, health + weapon.getHealth());
        this.attack = Math.max(0, attack + weapon.getAttack());
        this.defence = Math.max(0, defence + weapon.getDefense());
    }

    @Override
    public double getValue() {
        return ValueEnum.WARLORD_VALUE.getValue();
    }
}
