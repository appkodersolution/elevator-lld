package com.appkoder.elevator.system;

import com.appkoder.elevator.command.Command;
import com.appkoder.elevator.command.FloorRequestCommand;
import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Mediator: Manages communication between floors and elevators.
 * Uses a SchedulingStrategy to choose the best elevator.
 */
public class ElevatorMediator {
    private final List<Elevator> elevators;
    private final SchedulingStrategy strategy;
    private final Queue<FloorRequest> pendingRequests = new LinkedList<>();

    public ElevatorMediator(List<Elevator> elevators, SchedulingStrategy strategy) {
        this.elevators = elevators;
        this.strategy = strategy;
    }

    public void handleRequest(FloorRequest request) {
        System.out.println("Mediator: Handling request " + request);

        // Choose elevator via strategy
        Elevator chosenElevator = strategy.selectElevator(elevators, request);

        if (chosenElevator == null) {
            System.out.println("⏳ All elevators busy, adding request to pending queue: " + request);
            pendingRequests.add(request);
            return;
        }

        // Wrap in command
        Command cmd = new FloorRequestCommand(chosenElevator, request.getFloorNumber());
        cmd.execute();

        System.out.println("Mediator: Assigned elevator " + chosenElevator.getId() +
                " to serve floor " + request.getFloorNumber());
    }

    public void recheckPendingRequests() {
        if (!pendingRequests.isEmpty()) {
            FloorRequest req = pendingRequests.poll();
            handleRequest(req);
        }
    }
}
