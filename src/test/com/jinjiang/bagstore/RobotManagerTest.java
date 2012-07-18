package test.com.jinjiang.bagstore;

import com.jinjiang.bagstore.*;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotManagerTest {

    @Test
    public void should_be_able_to_store_bag() {
         List<Robot> robots = initData();
         RobotManager manager = new RobotManager(robots,new LockerWall(1));
         Ticket actualKey = manager.put(new Bag());
         Assert.assertNotNull(actualKey);
    }

    @Test(expected = LockerWallIsFullException.class)
    public void should_be_throw_BagStoreIsFullException_when_is_full() {
        List<Robot> robots = new ArrayList<Robot>();
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(0), new LockerWall(0));
        Robot smartRobot = new Robot(new ChooseWallImpl(), new LockerWall(0), new LockerWall(0));
        Robot rateRobot = new Robot(new ChooseWallImpl(), new LockerWall(0), new LockerWall(0));
        robots.add(robot);
        robots.add(smartRobot);
        robots.add(rateRobot);
        RobotManager manager = new RobotManager(robots,new LockerWall(0));
        manager.put(new Bag());
    }

    @Test
    public void should_be_return_bag_when_given_ticket() {
        List<Robot> robots = initData();
        RobotManager manager = new RobotManager(robots,new LockerWall(1));
        Bag bag =  new Bag();
        Ticket actualKey = manager.put(bag);
        Bag bagFromManager = manager.pop(actualKey);
        Assert.assertEquals(bag ,bagFromManager);

    }

    private List<Robot> initData() {
        List<Robot> robots = new ArrayList<Robot>();
        Robot robot = new Robot(new ChooseWallImpl(), new LockerWall(10), new LockerWall(5));
        Robot smartRobot = new Robot(new ChooseWallImpl(), new LockerWall(10), new LockerWall(5));
        Robot rateRobot = new Robot(new ChooseWallImpl(), new LockerWall(10), new LockerWall(5));
        robots.add(robot);
        robots.add(smartRobot);
        robots.add(rateRobot);
        return robots;
    }
}
