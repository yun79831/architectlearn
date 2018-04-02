package com.learn.patten.proxy.cutomer;

import com.learn.patten.proxy.demo.Courier;

import java.lang.reflect.Method;

/**
 * Created by ghost on 2018-04-02.
 */
public class MyExpressProxy implements MyInvocationHandler {

    private Courier courier;

    public Object getInstance(Courier courier) throws Exception {
        this.courier = courier;
        Class<?> classz = courier.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), classz.getInterfaces(), this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("快递公司代办中");
        method.invoke(this.courier, args);
        System.out.println("快递处理结束");
        return null;
    }
}
