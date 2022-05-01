package com.project.model.enemy.impl;

import com.project.model.army.EventMaker;
import com.project.model.army.impl.Solder;
import com.project.model.army.Subscriber;
import com.project.model.enemy.Enemy;

public class Healer extends Enemy implements Subscriber {

    private static final int HEAL = 2;

    public Healer() {
        super(60, 0);
    }

    @Override
    public void action(EventMaker eventMaker) {
        heal((Solder) eventMaker);
    }

    public void heal(Solder solder) {
        ((Enemy) solder.getWrapped()).healMe(HEAL);
    }
}
