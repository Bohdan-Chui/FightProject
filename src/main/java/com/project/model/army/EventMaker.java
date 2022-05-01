package com.project.model.army;

public interface EventMaker {

    void subscribe(Subscriber subscriber);

    void event();

}
