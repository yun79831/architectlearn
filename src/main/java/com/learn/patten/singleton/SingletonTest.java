package com.learn.patten.singleton;

import com.learn.patten.singleton.enumdemo.Color;
import com.learn.patten.singleton.hungry.Hungry;
import com.learn.patten.singleton.lazy.LazyFour;
import com.learn.patten.singleton.lazy.LazyOne;
import com.learn.patten.singleton.lazy.LazyTwo;
import com.learn.patten.singleton.lazy.LazyThree;
import com.learn.patten.singleton.register.BeanFactory;
import com.learn.patten.singleton.serial.Serial;
import org.junit.Test;

import java.io.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ghost on 2018-03-09.
 */
public class SingletonTest {
    public static void main(String[] args) {
        new SingletonTest().hungryTest();
    }

    //饿汉模式
    @Test
    public void hungryTest() {
        int count = 200;
        long star = System.currentTimeMillis();
        final CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    Hungry hungry = Hungry.getInstance();
                    System.out.println(System.currentTimeMillis() + "  " + hungry);
                    cdl.countDown();
                }
            }.start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:执行完成:" + (end - star));
    }

    //懒汉的几种实现方式
    @Test
    public void lazyTest() {
        int count = 1000;
        long star = System.currentTimeMillis();
        final CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
//                    LazyOne lazy = LazyOne.getInstance();
//                    LazyTwo lazy = LazyTwo.getInstance();
//                    LazyThree lazy = LazyThree.getInstance();
//                    LazyFour lazy = LazyFour.getInstance();
//                     Color lazy=Color.RED;
                    BeanFactory lazy = (BeanFactory) BeanFactory.getBean("com.learn.patten.singleton.register.BeanFactory");

                    System.out.println(System.currentTimeMillis() + "  " + lazy);
                    cdl.countDown();
                }
            }.start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time:执行完成:" + (end - star));
    }

    //反序列化时导致单例破坏
    @Test
    public void serialTest() {
        Serial s1 = Serial.getInstance();
        Serial s2 = Serial.getInstance();
        Serial s3 = null;
        System.out.println(s1);
        System.out.println(s2);


        try {
            FileOutputStream fos = new FileOutputStream("temp.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.flush();
            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream("temp.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s3 = (Serial) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(s3);
        System.out.println(s3==s2);

    }

}
