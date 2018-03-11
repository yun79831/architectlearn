package com.learn.patten.singleton.hungry;

/**
 * 饥汉模式
 * Created by ghost on 2018-03-09.
 * 是否 LazyTwo 初始化：否
 * 是否多线程安全：是
 * 一次初始化,到处使用 执行效率高
 * 不管是否使用都实例化 占用空间
 */
public class Hungry {
    private static final Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return hungry;
    }
}
