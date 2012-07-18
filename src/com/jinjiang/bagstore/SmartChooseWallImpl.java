package com.jinjiang.bagstore;

import java.util.List;

public class SmartChooseWallImpl implements ChooseWall {
    public SmartChooseWallImpl() {
    }

    @Override
    public LockerWall chooseLockerWall(List<LockerWall> walls) {
        LockerWall firstLockerWall = walls.get(0);
        for (LockerWall lockerWall : walls) {
            if (lockerWall.getEmptySize() > firstLockerWall.getEmptySize()) {
                firstLockerWall = lockerWall;
            }
        }
        return firstLockerWall;
    }
}