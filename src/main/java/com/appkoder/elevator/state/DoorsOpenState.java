package com.appkoder.elevator.state;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

/**
 * Represents the elevator with doors open.
 */
public class DoorsOpenState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, FloorRequest request) {
        System.out.println("🚪 Elevator " + elevator.getId() + " doors OPEN at floor " + elevator.getCurrentFloor());
        elevator.getDoor().open();

        // Remove the served request
        if (!elevator.getRequests().isEmpty()) {
            elevator.getRequests().poll();
        }

        // Close door and go idle after serving
        elevator.getDoor().close();
        elevator.setState(new IdleState());
    }
}
