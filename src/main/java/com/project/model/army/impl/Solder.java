package com.project.model.army.impl;

import com.project.model.army.Publisher;
import com.project.model.army.Linked;
import com.project.model.Valuable;
import com.project.model.army.Subscriber;
import com.project.model.enemy.Enemy;
import com.project.model.Fightable;
import com.project.model.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Solder implements Linked, Fightable, Publisher, Valuable {

    private final List<Subscriber> subscribers = new ArrayList<>();
    private final List<Weapon> weapons = new ArrayList<>();
    private final Fightable wrapped;
    private Solder behind;

    public Solder(Enemy current) {
        this.wrapped = current;
    }

    @Override
    public int hit(Fightable enemy) {
        notifySubscribers();
        return wrapped.hit(enemy);
    }

    @Override
    public int getDamage(int damage) {
        return wrapped.getDamage(damage);
    }

    @Override
    public int getAttack() {
        return wrapped.getAttack();
    }

    @Override
    public boolean isAlive() {
        return wrapped.isAlive();
    }

    @Override
    public void setBehind(Solder enemy) {
        this.behind = enemy;
    }

    @Override
    public Solder getBehind() {
        return behind;
    }

    public Fightable getWrapped() {
        return wrapped;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.action(this);
        }
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
        wrapped.equipWeapon(weapon);
    }

    @Override
    public double getValue() {
        return ((Valuable) wrapped).getValue();
    }
}
