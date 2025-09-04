package com.appkoder.elevator.observer;

import com.appkoder.elevator.model.Direction;

public interface Observer {
    void update(int floorNumber, Direction direction);
}
