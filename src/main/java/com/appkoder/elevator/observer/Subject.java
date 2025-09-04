package com.appkoder.elevator.observer;

import com.appkoder.elevator.model.Direction;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(int floorNumber, Direction direction);
}