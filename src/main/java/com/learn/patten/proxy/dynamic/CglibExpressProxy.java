package com.learn.patten.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理
 * Created by admin on 2018/3/10.
 */
public class CglibExpressProxy implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception {
        //要把哪个设置为即将生成的新类父类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("快递公司代办中");
        methodProxy.invokeSuper(o, objects);
        System.out.println("快递处理结束");
        return null;
    }
}
