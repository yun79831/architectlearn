package com.learn.patten.factory.func;

import com.learn.patten.factory.entity.Fruits;
import com.learn.patten.factory.entity.Strawberry;

/**
 * Created by admin on 2018/3/18.
 */
public class StrawberryFactory implements Factory {
    public Fruits createFruits() {
        return new Strawberry();
    }
}
