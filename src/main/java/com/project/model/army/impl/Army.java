package com.project.model.army.impl;

import com.project.model.army.Subscriber;
import com.project.model.enemy.Enemy;
import com.project.model.enemy.EnemyFactory;
import com.project.model.enemy.impl.Healer;
import com.project.model.enemy.impl.Lancer;
import com.project.model.enemy.impl.Warlord;

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

    public Solder getByIndex(int index) {
        return unitList.get(index);
    }

    private List<Solder> getEnemiesByClass(Class<? extends Enemy> enemyClass) {
        List<Solder> result = unitList.stream().filter(n -> n.getWrapped().getClass() == enemyClass).toList();
        unitList.removeAll(result);
        return result;
    }
    private Optional<Solder> getEnemyByClass(Class<? extends Enemy> enemyClass) {
        Optional<Solder> result = unitList.stream().filter(n -> n.getWrapped().getClass() == enemyClass).findFirst();
        result.ifPresent(solder -> unitList.remove(solder));
        return result;
    }

    public void moveUnits() {
        Optional<Solder> warlord = getEnemyByClass(Warlord.class);
        if (warlord.isEmpty()) {
            return;
        }
        List<Solder> result = new ArrayList<>(getEnemiesByClass(Lancer.class));
        List<Solder> healers = getEnemiesByClass(Healer.class);
        result.addAll(unitList);
        healers.forEach(healer -> {
            if (result.size() > 2) {
                result.add(1, healer);
            } else {
                result.add(healer);
            }
        });
        result.add(warlord.get());
        unitList = result;
    }

}