package com.learn.patten.singleton.demo;

/**
 * 饥汉模式
 * Created by ghost on 2018-03-09.
 */
public  class Hungry {
    private static Hungry hungry = new Hungry();

    private Hungry() {

    }

    public static Hungry getHungry() {
        return hungry;
    }
}
