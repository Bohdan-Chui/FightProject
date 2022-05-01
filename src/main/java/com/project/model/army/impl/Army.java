package com.project.model.army.impl;

import com.project.model.army.Subscriber;
import com.project.model.enemy.EnemyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Army {

    private List<Solder> unitList = new ArrayList<>();

    public Army addUnits(String enemyName, int i) {
        while (i > 0) {
            unitList.add(new Solder(new EnemyFactory().of(enemyName.toLowerCase(Locale.ROOT))));
            i--;
        }
        return this;
    }

    public Solder getAliveFighter() {

        if (unitList.isEmpty())
            return null;
        if (unitList.get(0).isAlive())
            return unitList.get(0);

        unitList.remove(0);

        return getAliveFighter();
    }

    public void prepareArmy() {
        setBehinds();
        subscribe();
    }

    public void setBehinds() {
        Iterator<Solder> iterator = unitList.iterator();
        Solder warrior = iterator.next();
        while (iterator.hasNext()) {
            Solder warrior1 = iterator.next();
            warrior.setBehind(warrior1);
            warrior = warrior1;
        }
    }

    public void subscribe() {
        unitList.forEach(solder -> {
            if (solder.getBehind() == null)
                return;
            if (solder.getBehind().getWrapped() instanceof Subscriber subscriber) {
                solder.subscribe(subscriber);
            }
        });
    }

    public int size() {
        return unitList.size();
    }

    public Iterator<Solder> getIterator() {
        return unitList.iterator();
    }

    public void filterArmyFromDied() {
        unitList = unitList.stream().filter(Solder::isAlive).collect(Collectors.toList());
    }
}
