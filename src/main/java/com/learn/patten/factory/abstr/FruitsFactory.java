package com.learn.patten.factory.abstr;

import com.learn.patten.factory.entity.Apple;
import com.learn.patten.factory.entity.Banana;
import com.learn.patten.factory.entity.Fruits;
import com.learn.patten.factory.entity.Strawberry;

/**
 * Created by admin on 2018/3/18.
 */
public class FruitsFactory extends AbstractFactory {

   public  Fruits createApple() {
        return new Apple();
    }

    public Fruits createBanana() {
        return new Banana();
    }

    public Fruits createStrawberry() {
        return new Strawberry();
    }
}
