package com.appkoder.elevator;

import com.appkoder.elevator.model.Direction;
import com.appkoder.elevator.model.FloorRequest;
import com.appkoder.elevator.system.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem system = ElevatorSystem.getInstance(3, 15, new NearestElevatorStrategy());

        // Start elevator simulation (each elevator runs independently)
        system.startSimulation();

        // Requests
        System.out.println("\n👤 Passenger at floor 5 presses UP:");
        system.submitRequest(new FloorRequest(5, Direction.UP));

        Thread.sleep(5000);

        System.out.println("\n👤 Passenger at floor 2 presses DOWN:");
        system.submitRequest(new FloorRequest(2, Direction.DOWN));

        Thread.sleep(5000);

        System.out.println("\n👤 Passenger at floor 12 presses DOWN:");
        system.submitRequest(new FloorRequest(12, Direction.DOWN));
    }
}