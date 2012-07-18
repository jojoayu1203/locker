package test.com.jinjiang.bagstore;

import com.jinjiang.bagstore.*;
import org.junit.Test;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;

public class RobotTest {

    @Test(expected = LockerWallIsFullException.class)
    public void should_be_throw_exception_when_all_wall_is_full() {
        LockerWall alocker = new LockerWall(1);
        alocker.put(new Bag());
        LockerWall blocker = new LockerWall(1);
        blocker.put(new Bag());

        Robot robot = new Robot(new RateChooseWallImpl(), alocker, blocker);
        Ticket ticket = robot.put(new Bag());
    }

    @Test
    public void should_be_bag_to_more_rate_locker_wall_when_given_two_wall() {
        LockerWall alocker = new LockerWall(4);
        alocker.put(new Bag());
        LockerWall blocker = new LockerWall(5);
        blocker.put(new Bag());

        Robot robot = new Robot(new RateChooseWallImpl(), alocker, blocker);
        Ticket ticket = robot.put(new Bag());
        org.junit.Assert.assertNotNull(ticket);
        org.junit.Assert.assertEquals(3, alocker.getEmptySize());
        org.junit.Assert.assertEquals(3, blocker.getEmptySize());
    }

    @Test
    public void should_be_able_to_store_bag() {
        Bag bag = new Bag();
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(10),new LockerWall(5));
        Ticket actualKey = robot.put(bag);
        Assert.assertNotNull(actualKey);
    }

    @Test
    public void should_be_return_bag_when_given_key() {
        Bag bag = new Bag();
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(10));
        Ticket key = robot.put(bag);
        Bag bagFromStore = robot.pop(key);
        Assert.assertSame(bag,bagFromStore);

    }

    @Test
    public void should_be_NullBag_when_given_not_exist_key() {
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(10));
        Assert.assertSame(Bag.NullBag, robot.pop(new Ticket()));
    }

    @Test(expected = LockerWallIsFullException.class)
    public void should_be_throw_BagStoreIsFullException_when_is_full() {
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(1));
        robot.put(new Bag());
        robot.put(new Bag());
    }

    @Test
    public void should_be_9_when_given_10_capacity_put_1() {
        Lockers robot = new Robot(new ChooseWallImpl(), new LockerWall(2),new LockerWall(1));
        Lockers smartRobot = new Robot(new SmartChooseWallImpl(), new LockerWall(1), new LockerWall(1));
        Lockers rateRobot = new Robot(new RateChooseWallImpl(), new LockerWall(3));
        Lockers lockers = new Robot(new ChooseWallImpl(), robot, smartRobot, rateRobot, new LockerWall(2));
        lockers.put(new Bag());
        Assert.assertEquals(9, lockers.getEmptySize());
    }
}
