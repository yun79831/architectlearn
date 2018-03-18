package com.learn.patten.proxy;

import com.learn.patten.proxy.staticed.PersonStaticProxy;
import com.learn.patten.proxy.demo.Son;
import org.junit.Test;

/**
 * 代理模式
 * Created by admin on 2018/3/10.
 * 动态代理和静态代理
 */
public class proxyTest {
    //静态台历  person代理  代理tom 去吃东西
    @Test
    public void staticedTest() {
        Son tom = new Son();
        PersonStaticProxy personStaticProxy = new PersonStaticProxy(tom);
        personStaticProxy.eat();
    }

    //动态代理
    @Test
    public void dynamicTest() {
        // net.sf.cglib.proxy.Proxy;
        //Proxy.newProxyInstance();
    }
}
