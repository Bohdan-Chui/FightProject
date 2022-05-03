package com.project.model.army;

@FunctionalInterface
public interface Subscriber {

    void action(EventMaker eventMaker);

}
