package com.project.model.weapon.impl;

import com.project.model.weapon.Weapon;

public class Katana extends Weapon {

    public Katana() {
        this.setHealth(-20);
        this.setAttack(6);
        this.setDefense(-5);
        this.setVampirism(50);
    }
}
