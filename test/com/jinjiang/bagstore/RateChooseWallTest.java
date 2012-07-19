package com.jinjiang.bagstore;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class RateChooseWallTest {

    @Test
    public void should_be_choose_more_rate_Locker_wall_when_give_two_wall() {
        List<Lockers> lockerWalls = new ArrayList<Lockers>();
        LockerWall aLockerWall = new LockerWall(4);
        aLockerWall.put(new Bag());
        lockerWalls.add(aLockerWall);
        LockerWall bLockerWall = new LockerWall(5);
        bLockerWall.put(new Bag());
        lockerWalls.add(bLockerWall);
        RateChooseWallImpl rateChooseWall = new RateChooseWallImpl();
        Assert.assertEquals(bLockerWall, rateChooseWall.chooseLockerWall(lockerWalls));
    }

    @Test
    public void should_be_choose_first_Locker_wall_when_give_two_same_wall() {
        List<Lockers> lockerWalls = new ArrayList<Lockers>();
        LockerWall aLockerWall = new LockerWall(5);
        aLockerWall.put(new Bag());
        lockerWalls.add(aLockerWall);
        LockerWall bLockerWall = new LockerWall(5);
        bLockerWall.put(new Bag());
        lockerWalls.add(bLockerWall);
        RateChooseWallImpl rateChooseWall = new RateChooseWallImpl();
        Assert.assertEquals(aLockerWall, rateChooseWall.chooseLockerWall(lockerWalls));
    }

    @Test
    public void should_be_choose_other_more_rate_Locker_wall_when_give_no_capacity_wall() {
        List<Lockers> lockerWalls = new ArrayList<Lockers>();
        LockerWall aLockerWall = new LockerWall(0);
        lockerWalls.add(aLockerWall);
        LockerWall bLockerWall = new LockerWall(3);
        bLockerWall.put(new Bag());
        lockerWalls.add(bLockerWall);
        LockerWall cLockerWall = new LockerWall(5);
        cLockerWall.put(new Bag());
        lockerWalls.add(cLockerWall);

        RateChooseWallImpl rateChooseWall = new RateChooseWallImpl();
        Assert.assertEquals(cLockerWall, rateChooseWall.chooseLockerWall((List<Lockers>) lockerWalls));
    }

    @Test
    public void should_be_return_null_when_is_full() {
        List<Lockers> lockerWalls = new ArrayList<Lockers>();
        LockerWall aLockerWall = new LockerWall(1);
        aLockerWall.put(new Bag());
        lockerWalls.add(aLockerWall);
        LockerWall bLockerWall = new LockerWall(1);
        bLockerWall.put(new Bag());
        lockerWalls.add(bLockerWall);
        LockerWall cLockerWall = new LockerWall(1);
        cLockerWall.put(new Bag());
        lockerWalls.add(cLockerWall);
        RateChooseWallImpl rateChooseWall = new RateChooseWallImpl();
        Assert.assertNull(rateChooseWall.chooseLockerWall((List<Lockers>) lockerWalls));
    }
}
