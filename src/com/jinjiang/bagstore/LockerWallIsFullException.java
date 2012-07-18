package com.jinjiang.bagstore;

public class LockerWallIsFullException extends RuntimeException {
    public LockerWallIsFullException() {
    }

    public LockerWallIsFullException(String msg) {
        super(msg);
    }
}
