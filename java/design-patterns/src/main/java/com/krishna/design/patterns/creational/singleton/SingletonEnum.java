package com.krishna.design.patterns.creational.singleton;

public enum SingletonEnum {
    INSTANCE;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }
}
