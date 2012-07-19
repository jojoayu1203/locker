package com.jinjiang.bagstore;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LockerWallTest {
    private LockerWall lockerWall;

    @Before
    public void init() {
        int defaultSize = 5;
        lockerWall = new LockerWall(defaultSize);
    }

    @Test
    public void should_be_return_key_when_put_bag() {
        Ticket ticket = lockerWall.put(new Bag());
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_be_return_bag_when_given_key() {
        Bag bag = new Bag();
        Ticket ticket = lockerWall.put(bag);
        Bag fromLockerWallBag = lockerWall.pop(ticket);
        Assert.assertSame(bag, fromLockerWallBag);
    }

    @Test
    public void should_be_return_null_when_given_not_exist_key() {
        Assert.assertSame(Bag.NullBag, lockerWall.pop(new Ticket()));
    }

    @Test
    public void should_be_return_null_when_repeat_get_by_key() {
        Bag expectedBag = new Bag();
        Ticket key = lockerWall.put(expectedBag);
        Bag actualBag = lockerWall.pop(key);
        Assert.assertSame(actualBag, expectedBag);
        actualBag = lockerWall.pop(key);
        Assert.assertSame(Bag.NullBag, actualBag);
    }

    @Test(expected = LockerWallIsFullException.class)
    public void should_be_throw_error_when_BagStore_is_full() {
        int maxSize = 0;
        LockerWall store = new LockerWall(maxSize);
        store.put(new Bag());
    }

    @Test
    public void should_be_able_to_tell_if_store_has_room() {
        int maxSize = 0;
        LockerWall store = new LockerWall(maxSize);
        Assert.assertTrue(store.isFull());
    }

    @Test
    public void should_be_able_to_tell_if_store_has_my_bag() {
        Bag bag = new Bag();
        Ticket key = lockerWall.put(bag);
        boolean result = lockerWall.contains(key);
        Assert.assertTrue(result);
    }

    @Test
    public void should_be_able_to_tell_if_store_does_not_have_my_bag() {
        boolean result = lockerWall.contains(new Ticket());
        Assert.assertFalse(result);
    }
}
