package com.jinjiang.bagstore;

import java.util.*;

public class Robot {
    private List<LockerWall> lockerWalls;
    private ChooseWall chooseWall;

    public List<LockerWall> getLockerWalls() {
		return lockerWalls;
	}

	public Robot(ChooseWall chooseWall, LockerWall... bagStores) {
        this.chooseWall = chooseWall;
        lockerWalls = new ArrayList<LockerWall>(bagStores.length);

        for (LockerWall bagStore : bagStores) {
            lockerWalls.add(bagStore);
        }
    }

    public Ticket put(Bag bag) {
        LockerWall lockerWall = chooseWall.chooseLockerWall(lockerWalls);
        return lockerWall.put(bag);
    }



    public Bag pop(Ticket key) {
        for (LockerWall store : lockerWalls) {
            if (store.contains(key)) {
                return store.pop(key);
            }
        }
        return Bag.NullBag;
    }
}
