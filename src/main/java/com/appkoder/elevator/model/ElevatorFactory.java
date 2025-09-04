package com.appkoder.elevator.model;

public class ElevatorFactory {
    public static Elevator createElevator(ElevatorType type, String id, int numFloors) {
        switch (type) {
            case STANDARD:
                return new Elevator.Builder(id)
                        .setCapacity(8)
                        .setWeightLimit(680)
                        .setCurrentFloor(1)
                        .build();
            case FREIGHT:
                return new Elevator.Builder(id)
                        .setCapacity(20)
                        .setWeightLimit(2000)
                        .setCurrentFloor(1)
                        .build();
            default:
                throw new IllegalArgumentException("Unknown elevator type: " + type);
        }
    }
}
