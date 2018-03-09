package com.learn.patten.singleton;

import com.learn.patten.singleton.demo.Hungry;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ghost on 2018-03-09.
 */
public class SingletonTest {
    public static void main(String[] args) {

    }

    //测试饥汉模式
    @Test
    public void hungryTest() {
        Integer t=Integer.valueOf(127);
        Integer t1=Integer.valueOf(128);
        int count = 200;
        //线程
        long star=System.currentTimeMillis();
        final CountDownLatch cdl = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    Hungry hungry = Hungry.getHungry();
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
        long end=System.currentTimeMillis();
        System.out.println("time:执行完成:"+(end-star));
    }

}
