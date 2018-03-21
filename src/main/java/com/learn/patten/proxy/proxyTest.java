package com.learn.patten.proxy;

import com.learn.patten.proxy.demo.Person;
import com.learn.patten.proxy.dynamic.CglibExpressProxy;
import com.learn.patten.proxy.jdk.JDKExpressProxy;
import com.learn.patten.proxy.staticed.StaticExpressProxy;
import com.learn.patten.proxy.demo.Tom;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 * Created by admin on 2018/3/10.
 * 动态代理和静态代理
 */
public class proxyTest {
    //静态台历  person代理  代理tom 去吃东西
    @Test
    public void staticedTest() {
        Tom tom = new Tom();
        StaticExpressProxy staticExpressProxy = new StaticExpressProxy(tom);
        staticExpressProxy.buyFlower();
    }

    //JDK动态代理
    @Test
    public void jdkDynamicTest() throws IOException {
        Person obj = (Person) new JDKExpressProxy().getInstance(new Tom());
        obj.buyFlower();
        System.out.println(obj.getClass());
        //查看生成的文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy4", new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();
    }


    //JDK动态代理练习
    @Test
    public void jdkDynamicTest2() throws Exception {
 /*       final Person person = new Tom();
        Person personProxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("测试");
                Object obj = method.invoke(person, args);
                System.out.println("代理处理结束");
                return obj;
            }
        });
        System.out.println(personProxy);*/
        //不知道为啥类加载会执行一次
    }


    //cglib动态代理
    @Test
    public void cglibDynamicTest() throws Exception {
        Tom obj = (Tom) new CglibExpressProxy().getInstance(Tom.class);
        obj.buyFlower();

    }

}
