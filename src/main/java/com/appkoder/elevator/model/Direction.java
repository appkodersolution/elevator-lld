package com.appkoder.elevator.model;

public enum Direction {
    UP,
    DOWN,
    NONE; // Idle state

    public boolean isMoving() {
        return this == UP || this == DOWN;
    }
}