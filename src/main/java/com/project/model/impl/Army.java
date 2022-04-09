package com.project.model.impl;

import java.util.ArrayList;

public class Army {
    private final ArrayList<Warrior> unitList;
    private int aliveIndex;

    public Army() {
        this.unitList = new ArrayList<>();
        aliveIndex = 0;
    }

    public Army addUnit(Class<? extends Warrior> clas, int i) {
        for (int j = 0; j < i; j++) {
            unitList.add(Warrior.getUnit(clas));
            if(j != 0)
                unitList.get(j-1).setSoldierBehind(unitList.get(j));
        }
        return this;
    }

    public Warrior getUnit() {
        if (unitList.get(aliveIndex).isAlive())
            return unitList.get(aliveIndex);
        if (aliveIndex + 1 >= unitList.size())
            return null;
        return unitList.get(++aliveIndex);
    }

}
