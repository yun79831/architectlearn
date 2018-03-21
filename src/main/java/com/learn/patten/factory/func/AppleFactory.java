package com.learn.patten.factory.func;

import com.learn.patten.factory.entity.Apple;
import com.learn.patten.factory.entity.Fruits;

/**
 * Created by admin on 2018/3/18.
 */
public class AppleFactory implements Factory {

    public Fruits createFruits() {
        return new Apple();
    }
}
