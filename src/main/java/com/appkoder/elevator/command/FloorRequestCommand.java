package com.appkoder.elevator.command;

import com.appkoder.elevator.model.Elevator;

/**
 * Command implementation for a floor request.
 * It encapsulates the action of assigning a floor request to an elevator.
 */
public class FloorRequestCommand implements Command {
    private final Elevator elevator;
    private final int floor;

    public FloorRequestCommand(Elevator elevator, int floor) {
        this.elevator = elevator;
        this.floor = floor;
    }

    @Override
    public void execute() {
        System.out.println("Executing FloorRequestCommand: assigning floor " + floor +
                " to elevator " + elevator.getId());
        elevator.addRequest(floor);
    }
}
