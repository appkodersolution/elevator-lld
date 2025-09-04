package com.appkoder.elevator.system;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

import java.util.List;

/**
 * Strategy interface for choosing the best elevator for a request.
 */
public interface SchedulingStrategy {
    Elevator selectElevator(List<Elevator> elevators, FloorRequest request);
}
