package com.learn.patten.prototype.entity;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/11.
 */
public class CPU implements Serializable {
    public String Frequency;
    public String Model;

    public CPU() {
        System.out.println("执行cpu构造函数0");
    }

    public CPU(String frequency, String model) {
        Frequency = frequency;
        Model = model;
        System.out.println("执行cpu构造函数");
    }
}
