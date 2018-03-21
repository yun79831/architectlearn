package com.learn.patten.template.demo;

/**
 * 做菜的模板
 * Created by ghost on 2018-03-21.
 */
public abstract class DoDishTemp {
    public void doDish() {
        preparation();
        doing();
        carriedDishes();
    }

    //准备调料
    public abstract void preparation();

    //做菜
    public abstract void doing();

    //上菜
    public abstract void carriedDishes();
}
