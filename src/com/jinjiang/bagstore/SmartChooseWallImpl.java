package com.jinjiang.bagstore;

import java.util.List;

public class SmartChooseWallImpl implements ChooseWall {
    public SmartChooseWallImpl() {
    }

    @Override
    public Lockers chooseLockerWall(List<Lockers> walls) {
        Lockers firstLockerWall = walls.get(0);
        for (Lockers lockerWall : walls) {
            if (lockerWall.getEmptySize() > firstLockerWall.getEmptySize()) {
                firstLockerWall = lockerWall;
            }
        }
        return firstLockerWall;
    }
}