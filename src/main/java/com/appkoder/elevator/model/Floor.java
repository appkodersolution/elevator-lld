package com.appkoder.elevator.model;

import com.appkoder.elevator.observer.Observer;
import com.appkoder.elevator.observer.Subject;
import com.appkoder.elevator.system.ElevatorMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a floor in the building.
 */
public class Floor implements Subject {
    private final int floorNumber;
    private final FloorPanel panel;
    private final List<Observer> observers = new ArrayList<>();
    private final ElevatorMediator mediator;

    public Floor(int floorNumber, ElevatorMediator mediator) {
        this.floorNumber = floorNumber;
        this.mediator = mediator;
        this.panel = new FloorPanel(floorNumber, mediator);
    }

    public int getFloorNumber() { return floorNumber; }
    public FloorPanel getPanel() { return panel; }

    @Override
    public void addObserver(Observer o) { observers.add(o); }

    @Override
    public void removeObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers(int floorNumber, Direction direction) {
        for (Observer o : observers) {
            o.update(floorNumber, direction);
        }
    }
}
