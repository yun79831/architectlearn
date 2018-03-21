package com.learn.patten.factory.entity;

/**
 * Created by admin on 2018/3/18.
 */
public class Strawberry implements Fruits {
    public String getName() {
        return "草莓";
    }

    public String desc() {
        return getName() + "描述:外观呈心形,鲜美红嫩,有光泽,果肉多汁,味道酸甜可口";
    }
}
