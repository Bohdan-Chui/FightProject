package com.project.model.impl;

import com.project.model.Fight;

public class ArmyBattle {
    Fight fight;

    public ArmyBattle() {
        fight = new FightImpl();
    }

    public boolean fight(Army army1, Army army2) {

        do{
            Warrior warrior1 = army1.getUnit();
            Warrior warrior2 = army2.getUnit();
            if(warrior1 == null)
                return false;
            if(warrior2 == null)
                return true;
            fight.fight(warrior1,warrior2);
        }while (true);

    }
}
