package com.jinjiang.bagstore;

import java.util.Comparator;

public class SortLocker implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		LockerWall lw1 = (LockerWall) o1;
		LockerWall lw2 = (LockerWall) o2;
		
		return 0;
	}


}
