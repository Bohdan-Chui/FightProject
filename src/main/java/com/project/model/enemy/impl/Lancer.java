package com.project.model.enemy.impl;

import com.project.model.army.impl.Solder;
import com.project.model.enemy.Enemy;
import com.project.model.Fightable;

public class Lancer extends Enemy {

    private static final int DAMAGE_DIVIDER = 2;

    public Lancer() {
        super(50, 6);
    }

    @Override
    public int hit(Fightable warrior) {
        int damage = warrior.getDamage(this.getAttack());
        if (((Solder) warrior).getBehind() != null)
            ((Solder) warrior).getBehind().getDamage(damage / DAMAGE_DIVIDER);
        return damage;
    }


}
