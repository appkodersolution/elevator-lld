package com.appkoder.elevator.system;

import com.appkoder.elevator.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Singleton ElevatorSystem: manages all elevators, floors, and dispatching.
 */
public class ElevatorSystem {
    private static volatile ElevatorSystem instance;
    private static final Object lock = new Object();

    private final List<Elevator> elevators;
    private final List<Floor> floors;
    private final ElevatorMediator mediator;
    private final ExecutorService executor;

    private ElevatorSystem(int numElevators, int numFloors, SchedulingStrategy strategy) {
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(5);
        this.mediator = new ElevatorMediator(elevators, strategy);

        // Initialize elevators
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(ElevatorFactory.createElevator(ElevatorType.STANDARD, "E" + i, numFloors));
        }

        // Initialize floors
        for (int i = 1; i <= numFloors; i++) {
            floors.add(new Floor(i, mediator));
        }
    }

    public static ElevatorSystem getInstance(int numElevators, int numFloors, SchedulingStrategy strategy) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ElevatorSystem(numElevators, numFloors, strategy);
                }
            }
        }
        return instance;
    }

    public void submitRequest(FloorRequest request) {
        executor.submit(() -> mediator.handleRequest(request));
    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void startSimulation() {
        for (Elevator e : elevators) {
            executor.submit(() -> {
                while (true) {
                    e.move();
                    try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                }
            });
        }
    }
}
