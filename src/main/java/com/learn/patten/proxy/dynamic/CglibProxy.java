package com.learn.patten.proxy.dynamic;

import com.learn.patten.proxy.staticed.Tom;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by admin on 2018/3/10.
 */
public class CglibProxy implements InvocationHandler {
    public Object getInstance(Class<?> c) {
        //原理
//        拿到被代理对象的引用,并且获取它的所有接口,反射湖区
//        JDK Proxy重新生成一个新的类,同时新的类要实现被代理类所有实现的方法
//        动态生成java代码,把新加的业务逻辑方法有一定的逻辑代码去调用
//        把新生成的java代码.class
//        再重新加载到jvm中运行
//        以上这个过程就叫字节码重组
        //JDK 中$开头的类 是自动生成的 内部类
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0.class", new Class[]{Tom.class});
        try {
            FileOutputStream os = new FileOutputStream("d://$Proxy.class");
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
