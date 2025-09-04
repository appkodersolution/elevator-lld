package com.appkoder.elevator.state;

import com.appkoder.elevator.model.Elevator;
import com.appkoder.elevator.model.FloorRequest;

/**
 * State interface for the Elevator (State Pattern).
 */
public interface ElevatorState {
    void handleRequest(Elevator elevator, FloorRequest request);
}
