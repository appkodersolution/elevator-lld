package com.appkoder.elevator.system;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

import java.util.List;

/**
 * Strategy: Picks the elevator with the smallest request queue.
 */
public class LeastLoadStrategy implements SchedulingStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, FloorRequest request) {
        Elevator best = elevators.get(0);

        for (Elevator e : elevators) {
            if (e.getRequestQueueSize() < best.getRequestQueueSize()) {
                best = e;
            }
        }

        System.out.println("LeastLoadStrategy: Chose elevator " + best.getId());
        return best;
    }
}
