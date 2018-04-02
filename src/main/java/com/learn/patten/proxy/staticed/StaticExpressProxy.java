package com.learn.patten.proxy.staticed;

import com.learn.patten.proxy.demo.Courier;
import com.learn.patten.proxy.demo.Tom;

/**
 * 快递代理
 * Created by admin on 2018/3/10.
 */
public class StaticExpressProxy {
    Courier courier;

    public StaticExpressProxy(Courier t) {
        this.courier = t;
    }

    public void buyFlower() {
        System.out.println("快递公司代办中");
        courier.buyFlower();
        System.out.println("快递公司处理结束");

    }
}
