package com.learn.patten.template.demo;

/**
 * Created by ghost on 2018-03-21.
 */
public class BouilliDish extends DoDishTemp {
    public void preparation() {
        System.out.println("准备肉");
    }

    public void doing() {
        System.out.println("做红烧肉");
    }

    public void carriedDishes() {
        System.out.println("上红烧肉");
    }
}
