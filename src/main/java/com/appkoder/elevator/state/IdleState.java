package com.appkoder.elevator.state;

import com.appkoder.elevator.model.Direction;
import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

/**
 * Represents the idle state of the elevator.
 */
public class IdleState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, FloorRequest request) {
        int current = elevator.getCurrentFloor();
        int target = request.getFloorNumber();

        if (target > current) {
            System.out.println("Elevator " + elevator.getId() + " starting to move UP from floor " + current);
            elevator.setState(new MovingUpState());
        } else if (target < current) {
            System.out.println("Elevator " + elevator.getId() + " starting to move DOWN from floor " + current);
            elevator.setState(new MovingDownState());
        } else {
            System.out.println("Elevator " + elevator.getId() + " already at floor " + current + " -> Doors opening");
            elevator.setState(new DoorsOpenState());
        }
    }
}
