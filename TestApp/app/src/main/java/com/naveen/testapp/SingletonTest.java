package com.naveen.testapp;

public class SingletonTest {
    private static final SingletonTest ourInstance = new SingletonTest();

    Model testModel = new Model();

    public static SingletonTest getInstance() {
        return ourInstance;
    }

    private SingletonTest() {
    }
}
