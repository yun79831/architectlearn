package com.learn.patten.proxy.staticed;

import com.learn.patten.proxy.demo.Son;

/**
 * Created by admin on 2018/3/10.
 */
public class PersonStaticProxy {
    Son tom;

    public PersonStaticProxy(Son t) {
        this.tom = t;
    }

    public void eat() {
        //代理  tom去吃
        tom.eat();
    }
}
