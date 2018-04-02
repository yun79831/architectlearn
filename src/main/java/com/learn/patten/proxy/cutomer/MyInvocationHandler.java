package com.learn.patten.proxy.cutomer;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/3/10.
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
