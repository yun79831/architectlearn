package com.learn.patten.factory.entity;

/**
 * Created by admin on 2018/3/18.
 */
public class Banana  implements Fruits {
    public String getName() {
        return "香蕉";
    }

    public String desc() {
        return  getName() + "描述:口感细腻润滑，甜中带香，十分美味";
    }
}
