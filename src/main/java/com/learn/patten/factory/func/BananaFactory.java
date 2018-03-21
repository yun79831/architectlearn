package com.learn.patten.factory.func;

import com.learn.patten.factory.entity.Banana;
import com.learn.patten.factory.entity.Fruits;

/**
 * Created by admin on 2018/3/18.
 */
public class BananaFactory implements Factory {
    public Fruits createFruits() {
        return new Banana();
    }
}
