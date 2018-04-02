package com.learn.patten.observer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ghost on 2018-04-02.
 */
public class MouseHandler extends MouseListener implements InvocationHandler {
    private IMouse target;

    public MouseHandler() {
        this.target = target;
    }

    public Object newInstence(IMouse target){
        this.target=target;
        Class<?> clazz=target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target, args);
        this.trigger(method.getName());
        return null;
    }
}
