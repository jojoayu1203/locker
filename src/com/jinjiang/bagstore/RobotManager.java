package com.jinjiang.bagstore;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class RobotManager {

    private Robot selfRobot;

    private List<Robot> robots;

    public RobotManager(List<Robot> robots, LockerWall... lockerWalls) {
        selfRobot = new Robot(new ChooseWallImpl(), lockerWalls);
        this.robots = robots;
        robots.add(selfRobot);
    }

    public Ticket put(Bag bag) {
        Ticket ticket = null;
        if (isFull()) {
            throw new LockerWallIsFullException("All lockerWall is full");
        }
        for (Robot robot : robots) {
            try {
                ticket = robot.put(bag);
                break;
            } catch (LockerWallIsFullException e) {
            }
        }
        return ticket;
    }

    private boolean isFull() {
        for (Robot robot : robots) {
            if (!robot.isFull()) {
                return false;
            }
        }
        return true;
    }

    public Bag pop(Ticket ticket) {
        for (Robot robot : robots) {
            Bag bag = robot.pop(ticket);
            if (bag != Bag.NullBag)
                return bag;

        }
        return Bag.NullBag;
    }
}
