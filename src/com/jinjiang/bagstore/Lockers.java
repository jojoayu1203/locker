package com.jinjiang.bagstore;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/18/12
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Lockers {
    Ticket put(Bag bag);

    Bag pop(Ticket storeKey);

    int getEmptySize();

    double getFullRate();

    boolean contains(Ticket key);

    boolean isFull();
}
