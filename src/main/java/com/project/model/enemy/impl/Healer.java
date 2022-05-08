package com.project.model.enemy.impl;

import com.project.model.army.Publisher;
import com.project.model.army.ValueEnum;
import com.project.model.army.impl.Solder;
import com.project.model.army.Subscriber;
import com.project.model.enemy.Enemy;
import com.project.model.weapon.Weapon;

public class Healer extends Enemy implements Subscriber {

    private int healingPower = 2;

    public Healer() {
        super(60, 0);
    }

    @Override
    public void action(Publisher publisher) {
        ((Enemy) ((Solder) publisher).getWrapped()).healMe(healingPower);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        this.startHealth = Math.max(0, startHealth + weapon.getHealth());
        this.health = Math.max(0, health + weapon.getHealth());
        this.attack = Math.max(0, attack + weapon.getAttack());
        this.healingPower = Math.max(0, healingPower + weapon.getHealPower());
    }

    @Override
    public double getValue() {
        return ValueEnum.HEALER_VALUE.getValue();
    }
}
