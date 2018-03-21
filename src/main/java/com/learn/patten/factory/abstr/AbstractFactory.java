package com.learn.patten.factory.abstr;

import com.learn.patten.factory.entity.Fruits;

/**
 * 抽象工厂种类
 * 为创建一组相关或者是相互依赖的对象提供的一个接口，而不需要指定它们的具体类。
 * Created by admin on 2018/3/18.
 */
public abstract class AbstractFactory {
    abstract Fruits createApple();

    abstract Fruits createBanana();

    abstract Fruits createStrawberry();

}
