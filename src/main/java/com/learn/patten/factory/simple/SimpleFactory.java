package com.learn.patten.factory.simple;

import com.learn.patten.factory.entity.Apple;
import com.learn.patten.factory.entity.Banana;
import com.learn.patten.factory.entity.Fruits;
import com.learn.patten.factory.entity.Strawberry;

/**
 * Created by admin on 2018/3/18.
 */
public class SimpleFactory {
    public static Fruits createFruits(String name) {
        if ("苹果".equals(name)) {
            return new Apple();
        } else if ("香蕉".equals(name)) {
            return new Banana();
        } else if ("草莓".equals(name)) {
            return new Strawberry();
        } else {
            System.out.println("没有该水果");
            return null;
        }
    }
}
