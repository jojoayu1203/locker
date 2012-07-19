package com.jinjiang.bagstore;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class RateChooseWallImpl implements ChooseWall {
    @Override
    public Lockers chooseLockerWall(List<Lockers> walls) {
        Lockers firstLockerWall = walls.get(0);
        for (Lockers lockerWall : walls) {
            if (lockerWall.getFullRate() < firstLockerWall.getFullRate()) {
                firstLockerWall = lockerWall;
            }
        }
        if (firstLockerWall.isFull()) {
            return null;
        }
        return firstLockerWall;
    }
}
