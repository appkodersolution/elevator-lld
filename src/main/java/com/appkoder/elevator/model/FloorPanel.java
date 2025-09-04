package com.appkoder.elevator.model;

import com.appkoder.elevator.system.ElevatorMediator;

public class FloorPanel {
    private final int floorNumber;
    private final ElevatorMediator mediator;

    public FloorPanel(int floorNumber, ElevatorMediator mediator) {
        this.floorNumber = floorNumber;
        this.mediator = mediator;
    }

    public void pressButton(Direction direction) {
        System.out.println("Floor " + floorNumber + " button pressed: " + direction);
        mediator.handleRequest(new FloorRequest(floorNumber, direction));
    }
}
