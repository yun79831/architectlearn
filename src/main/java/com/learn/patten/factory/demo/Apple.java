package com.learn.patten.factory.demo;

/**
 * Created by admin on 2018/3/18.
 */
public class Apple implements Fruits {

    public String getName() {
        return "苹果";
    }

    public String desc() {
        return getName() + "描述:果肉黄白色，致密细脆，多汁，酸甜适度";
    }
}
