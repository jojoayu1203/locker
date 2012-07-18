package com.jinjiang.bagstore;

import java.util.List;

public class ChooseWallImpl implements ChooseWall {
    public ChooseWallImpl() {
    }

    public LockerWall chooseLockerWall(List<LockerWall> walls) {
        LockerWall lockerWall = walls.get(0);
        for (LockerWall store : walls) {
            if (!store.isFull()) {
                lockerWall = store;
                break;
            }
        }
        return lockerWall;
    }
}