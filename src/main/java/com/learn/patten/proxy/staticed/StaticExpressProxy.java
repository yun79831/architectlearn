package com.learn.patten.proxy.staticed;

import com.learn.patten.proxy.demo.Tom;

/**
 * 快递代理
 * Created by admin on 2018/3/10.
 */
public class StaticExpressProxy {
    Tom tom;

    public StaticExpressProxy(Tom t) {
        this.tom = t;
    }

    public void buyFlower() {
        System.out.println("快递公司代办中");
        tom.buyFlower();
        System.out.println("快递公司处理结束");

    }
}
