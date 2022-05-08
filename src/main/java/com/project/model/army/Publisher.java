package com.project.model.army;

public interface Publisher {

    void addSubscriber(Subscriber subscriber);

    void notifySubscribers();

}
