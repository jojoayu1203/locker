package com.jinjiang.bagstore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockerWall {
    private Map<Ticket, Bag> bags = new ConcurrentHashMap<Ticket, Bag>();
    private int capacity;

    public LockerWall(int capacity) {
        this.capacity = capacity;
    }

    public Ticket put(Bag bag) {
        if (isFull()) {
            throw new LockerWallIsFullException();
        }
        Ticket key = new Ticket();
        bags.put(key, bag);
        return key;
    }

    public Bag pop(Ticket storeKey) {
        if (!bags.containsKey(storeKey)) {
            return Bag.NullBag;
        }
        Bag bag = bags.get(storeKey);
        bags.remove(storeKey);
        return bag;
    }

    public boolean isFull() {
        return capacity <= bags.size();
    }

    public boolean contains(Ticket key) {
        return bags.containsKey(key);
    }

	public int getEmptySize() {
		return  this.capacity - bags.size();
	}
}
