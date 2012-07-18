package com.jinjiang.bagstore;

import java.util.*;

public class Robot implements Lockers{
    private List<Lockers> lockerses;
    private ChooseWall chooseWall;

	public Robot(ChooseWall chooseWall, Lockers... lockerses) {
        this.chooseWall = chooseWall;
        this.lockerses = new ArrayList<Lockers>(lockerses.length);

        for (Lockers bagStore : lockerses) {
            this.lockerses.add(bagStore);
        }
    }

    public Ticket put(Bag bag) {
        Lockers lockerWall = chooseWall.chooseLockerWall(lockerses);
        if(lockerWall == null) {
            throw new LockerWallIsFullException("all wall is full!");
        }
        return lockerWall.put(bag);
    }



    public Bag pop(Ticket key) {
        for (Lockers store : lockerses) {
            if (store.contains(key)) {
                return store.pop(key);
            }
        }
        return Bag.NullBag;
    }

    @Override
    public int getEmptySize() {
        int total = 0;
        for(Lockers lockers : lockerses) {
            total = total+lockers.getEmptySize();
        }
        return total;
    }

    @Override
    public double getFullRate() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Ticket key) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isFull() {
        for (Lockers lockerWall : lockerses) {
            if(!lockerWall.isFull()){
                return  false;
            }
        }
        return true;
    }
}
