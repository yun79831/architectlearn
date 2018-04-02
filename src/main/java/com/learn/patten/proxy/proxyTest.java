package com.learn.patten.proxy;

import com.learn.patten.proxy.cutomer.MyExpressProxy;
import com.learn.patten.proxy.demo.Courier;
import com.learn.patten.proxy.dynamic.CglibExpressProxy;
import com.learn.patten.proxy.jdk.JDKExpressProxy;
import com.learn.patten.proxy.staticed.StaticExpressProxy;
import com.learn.patten.proxy.demo.Tom;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 代理模式
 * Created by admin on 2018/3/10.
 * 动态代理和静态代理
 */
public class proxyTest {
    //静态代理  Courier代理  代理tom 去买花
    @Test
    public void staticedTest() {
        StaticExpressProxy staticExpressProxy = new StaticExpressProxy(new Tom());
        staticExpressProxy.buyFlower();
    }
    //JDK动态代理
    @Test
    public void jdkDynamicTest() throws IOException {
        Courier obj = (Courier) new JDKExpressProxy().getInstance(new Tom());
        obj.buyFlower();


        System.out.println(obj.getClass());
        //查看生成的文件
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy4", new Class[]{Courier.class});
        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();
    }
    //cglib动态代理
    @Test
    public void cglibDynamicTest() throws Exception {
        Tom obj = (Tom) new CglibExpressProxy().getInstance(Tom.class);
        obj.buyFlower();
    }

    //自定义动态代理练习
    @Test
    public void MyDynamicTest() throws Exception {
        Courier obj = (Courier) new MyExpressProxy().getInstance(new Tom());
        obj.buyFlower();
    }




}
