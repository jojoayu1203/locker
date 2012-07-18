package com.jinjiang.bagstore;

import java.util.List;

public class ChooseWallImpl implements ChooseWall {
    public ChooseWallImpl() {
    }

    public Lockers chooseLockerWall(List<Lockers> walls) {
        Lockers lockerWall = walls.get(0);
        for (Lockers store : walls) {
            if (!store.isFull()) {
                lockerWall = store;
                break;
            }
        }
        return lockerWall;
    }
}