package com.learn.patten.factory;

import com.learn.patten.factory.abstr.FruitsFactory;
import com.learn.patten.factory.entity.Fruits;
import com.learn.patten.factory.func.AppleFactory;
import com.learn.patten.factory.func.BananaFactory;
import com.learn.patten.factory.func.Factory;
import com.learn.patten.factory.func.StrawberryFactory;
import com.learn.patten.factory.simple.SimpleFactory;
import org.junit.Test;

/**
 * Created by admin on 2018/3/18.
 */
public class FactoryTest {
    @Test
    public void simpleFactoryTest() {
        //静态方法工厂模式
        Fruits f = SimpleFactory.createFruits("苹果");
        System.out.println(f.desc());
    }

    @Test
    public void funFactoryTest() {
        //方法工厂模式 对应的工厂类来生成对应的产品类
        Factory f = new AppleFactory();
        System.out.println(f.createFruits().desc());
        Factory f1 = new BananaFactory();
        System.out.println(f1.createFruits().desc());
        Factory f2 = new StrawberryFactory();
        System.out.println(f2.createFruits().desc());
    }

    @Test
    public void abstrFactoryTest() {
        //抽象工厂模式 对应的工厂类来生成对应的产品类
        FruitsFactory fruitsFactory = new FruitsFactory();
        System.out.println(fruitsFactory.createApple().desc());
    }
}
