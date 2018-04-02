package com.learn.patten.observer.proxy;

import java.awt.image.ImageConsumer;

/**
 * 具体被观察者
 * Created by ghost on 2018-04-02.
 */
public class Mouse implements IMouse {
    public void click() {
        System.out.println("鼠标点击");
    }

    public void move() {
        System.out.println("鼠标移动");
    }
}
