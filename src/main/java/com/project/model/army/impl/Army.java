package com.project.model.army.impl;

import com.project.model.army.Subscriber;
import com.project.model.army.ValueEnum;
import com.project.model.enemy.EnemyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Army implements Iterable<Solder> {

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

    public int size() {
        return unitList.size();
    }

    public void filterArmyFromDied() {
        unitList = unitList.stream().filter(Solder::isAlive).collect(Collectors.toList());
    }

    public Solder getByIndex(int index) {
        return unitList.get(index);
    }

    private List<Solder> getByValuable(double value) {
        return unitList.stream().filter(solder -> solder.getValue() == value).toList();
    }

    public void moveUnits() {
        List<Solder> warlords = getByValuable(ValueEnum.WARLORD_VALUE.getValue());

        if (warlords.isEmpty()) {
            return;
        }
        unitList.removeAll(warlords);

        Optional<Solder> lancerOptional = getByValuable(ValueEnum.LANCER_VALUE.getValue()).stream()
                .findFirst();
        lancerOptional.ifPresent(lancer -> {
            unitList.remove(lancer);
            unitList.add(0, lancer);
        });

        List<Solder> healers = getByValuable(ValueEnum.HEALER_VALUE.getValue());
        if (!healers.isEmpty()) {
            unitList.removeAll(healers);
            if(unitList.isEmpty()){
                unitList.addAll(healers);
            }else {
                unitList.addAll(1, healers);
            }
        }

        unitList.add(warlords.get(0));
        prepareArmy();
    }

    public void prepareArmy() {
        Iterator<Solder> iterator = unitList.iterator();
        Solder warrior = iterator.next();
        while (iterator.hasNext()) {
            Solder warrior1 = iterator.next();
            warrior.setBehind(warrior1);
            warrior = warrior1;
        }
        unitList.forEach(solder -> {
            if (solder.getBehind() == null)
                return;
            if (solder.getBehind().getWrapped() instanceof Subscriber subscriber) {
                solder.resetSubscribers();
                solder.addSubscriber(subscriber);
            }
        });
    }

    @Override
    public Iterator<Solder> iterator() {
        return unitList.iterator();
    }

}