package com.project.model.enemy.impl;

import com.project.model.army.EventMaker;
import com.project.model.army.impl.Solder;
import com.project.model.army.Subscriber;
import com.project.model.enemy.Enemy;
import com.project.model.weapon.Weapon;

public class Healer extends Enemy implements Subscriber {

    private int heal = 2;

    public Healer() {
        super(60, 0);
    }

    @Override
    public void action(EventMaker eventMaker) {
        heal((Solder) eventMaker);
    }

    public void heal(Solder solder) {
        ((Enemy) solder.getWrapped()).healMe(heal);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.startHealth = Math.max(0, startHealth + weapon.getHealth());
        this.health = Math.max(0, health + weapon.getHealth());
        this.attack = Math.max(0, attack + weapon.getAttack());
        this.heal =  Math.max(0, heal + weapon.getHealPower());
    }
}
