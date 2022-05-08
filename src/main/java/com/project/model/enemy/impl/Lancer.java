package com.project.model.enemy.impl;

import com.project.model.army.ValueEnum;
import com.project.model.army.impl.Solder;
import com.project.model.enemy.Enemy;
import com.project.model.Fightable;

public class Lancer extends Enemy {

    private static final int DAMAGE_DIVIDER = 2;

    public Lancer() {
        super(50, 6);
    }

    @Override
    public int hit(Fightable fightable) {
        if (fightable instanceof Solder solder) {
            return hit(solder);
        } else {
            return fightable.getDamage(this.getAttack());
        }
    }

    public int hit(Solder warrior) {
        int damage = warrior.getDamage(this.getAttack());
        if (warrior.getBehind() != null)
            warrior.getBehind().getDamage(damage / DAMAGE_DIVIDER);
        return damage;
    }

    @Override
    public double getValue() {
        return ValueEnum.LANCER_VALUE.getValue();
    }
}
