package test.com.jinjiang.bagstore;

import com.jinjiang.bagstore.*;
import junit.framework.Assert;

import org.junit.Test;

public class SmartRobotTest {
	
	@Test
	public void should_be_bag_to_more_empty_locker_wall_when_given_two_wall() {
		LockerWall alocker = new LockerWall(5);
		LockerWall blocker = new LockerWall(10);

        Robot robot = new Robot(new SmartChooseWallImpl(), alocker, blocker);
		Ticket ticket = robot.put(new Bag());
		Assert.assertNotNull(ticket);
		Assert.assertEquals(5, alocker.getEmptySize());
		Assert.assertEquals(9, blocker.getEmptySize());
		
	}

    @Test
    public void should_be_bag_to_first_locker_wall_when_given_two_same_capacity_wall() {
        LockerWall alocker = new LockerWall(10);
        LockerWall blocker = new LockerWall(10);

        Robot robot = new Robot(new SmartChooseWallImpl(), alocker, blocker);
        Ticket ticket = robot.put(new Bag());
        Assert.assertNotNull(ticket);
        Assert.assertEquals(9, alocker.getEmptySize());
        Assert.assertEquals(10, blocker.getEmptySize());
    }


}
