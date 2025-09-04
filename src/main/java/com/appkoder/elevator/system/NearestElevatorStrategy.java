package com.appkoder.elevator.system;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

import java.util.List;

/**
 * Strategy: Picks the elevator closest to the requested floor.
 */
public class NearestElevatorStrategy implements SchedulingStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, FloorRequest request) {
        Elevator best = elevators.get(0);
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - request.getFloorNumber());
            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        System.out.println("NearestElevatorStrategy: Chose elevator " + best.getId());
        return best;
    }
}
