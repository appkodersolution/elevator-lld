package com.appkoder.elevator.model;

public class FloorRequest {
    private final int floorNumber;
    private final Direction direction;

    public FloorRequest(int floorNumber, Direction direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Request{ floor=" + floorNumber + ", direction=" + direction + " }";
    }
}
