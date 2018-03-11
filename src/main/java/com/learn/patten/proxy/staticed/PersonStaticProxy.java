package com.learn.patten.proxy.staticed;

/**
 * Created by admin on 2018/3/10.
 */
public class PersonStaticProxy {
    Tom tom;

    public PersonStaticProxy(Tom t) {
        this.tom = t;
    }

    public void eat() {
        //代理  tom去吃
        tom.eat();
    }
}
