package com.learn.patten.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ghost on 2018-03-21.
 */
public class JDKExpressProxy implements InvocationHandler {

//        原理
//        拿到被代理对象的引用,并且获取它的所有接口,反射湖区
//        JDK Proxy重新生成一个新的类,同时新的类要实现被代理类所有实现的方法
//        动态生成java代码,把新加的业务逻辑方法有一定的逻辑代码去调用
//        把新生成的java代码.class
//        再重新加载到jvm中运行
//        以上这个过程就叫字节码重组
//        JDK 中$开头的类 是自动生成的 内部类

    private Object object;

    public Object getInstance(Object object) {
        this.object = object;
        Class<?> classz = object.getClass();
        return Proxy.newProxyInstance(classz.getClassLoader(), classz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("快递公司代办中");
        method.invoke(this.object, args);
        System.out.println("快递处理结束");
        return null;
    }
}
