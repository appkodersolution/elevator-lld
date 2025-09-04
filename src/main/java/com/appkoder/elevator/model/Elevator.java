package com.appkoder.elevator.model;

import com.appkoder.elevator.state.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Elevator entity built with Builder Pattern.
 * Uses State Pattern for transitions.
 */
public class Elevator {
    private final String id;
    private final int capacity;
    private final int weightLimit;
    private int currentFloor;
    private ElevatorState state;
    private final Queue<Integer> requests = new LinkedList<>();
    private final Door door = new Door();

    private Elevator(Builder builder) {
        this.id = builder.id;
        this.capacity = builder.capacity;
        this.weightLimit = builder.weightLimit;
        this.currentFloor = builder.currentFloor;
        this.state = new IdleState();
    }

    public void addRequest(int floor) {
        requests.add(floor);
    }

    public void move() {
        if (requests.isEmpty()) {
            if (!(state instanceof IdleState)) {
                System.out.println("🛑 Elevator " + id + " is now idle at floor " + currentFloor);
            }
            state = new IdleState();
            return;
        }

        int target = requests.peek();
        state.handleRequest(this, new FloorRequest(target, Direction.NONE));
    }

    // Getters and setters
    public void setState(ElevatorState newState) { this.state = newState; }
    public int getCurrentFloor() { return currentFloor; }
    public void setCurrentFloor(int floor) { this.currentFloor = floor; }
    public Queue<Integer> getRequests() { return requests; }
    public int getRequestQueueSize() { return requests.size(); }
    public String getId() { return id; }
    public Door getDoor() { return door; }

    public static class Builder {
        private final String id;
        private int capacity;
        private int weightLimit;
        private int currentFloor = 1;

        public Builder(String id) { this.id = id; }
        public Builder setCapacity(int c) { this.capacity = c; return this; }
        public Builder setWeightLimit(int w) { this.weightLimit = w; return this; }
        public Builder setCurrentFloor(int f) { this.currentFloor = f; return this; }
        public Elevator build() { return new Elevator(this); }
    }
}
