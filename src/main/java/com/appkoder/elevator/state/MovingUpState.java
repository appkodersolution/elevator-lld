package com.appkoder.elevator.state;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

/**
 * Represents the elevator moving up.
 */
public class MovingUpState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, FloorRequest request) {
        int current = elevator.getCurrentFloor();
        int target = request.getFloorNumber();

        if (current < target) {
            elevator.setCurrentFloor(current + 1);
            System.out.println("⬆️ Elevator " + elevator.getId() + " moving UP to floor " + elevator.getCurrentFloor());
        }

        if (elevator.getCurrentFloor() == target) {
            System.out.println("Elevator " + elevator.getId() + " reached target floor " + target + " -> Doors opening");
            elevator.setState(new DoorsOpenState());
        }
    }
}
