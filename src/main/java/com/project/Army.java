package com.project;

import com.project.model.enemy.Enemy;
import com.project.model.enemy.Warrior;

import java.util.ArrayList;
import java.util.Iterator;

public class Army {
    private final ArrayList<Warrior> unitList;
    private int aliveIndex;

    public Army() {
        this.unitList = new ArrayList<>();
        aliveIndex = 0;
    }

    public Army addUnits(Enemy.Type type, int i) {
        for (int j = 0; j < i; j++)
            unitList.add(Warrior.getUnit(type));
        setBehinds();
        return this;
    }
    private void setBehinds(){
        Iterator<Warrior> iterator = unitList.iterator();
        Warrior warrior = iterator.next();
        while (iterator.hasNext()){
            Warrior warrior1 = iterator.next();
            warrior.setSoldierBehind(warrior1);
            warrior = warrior1;
        }
    }

    public Warrior getUnit() {
        if (unitList.get(aliveIndex).isAlive())
            return unitList.get(aliveIndex);
        if (aliveIndex + 1 >= unitList.size())
            return null;
        return unitList.get(++aliveIndex);
    }

}
