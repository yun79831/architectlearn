package com.learn.patten.singleton.lazy;

/**
 * 懒汉模式 线程安全
 * Created by admin on 2018/3/10.
 * 是否Lazy 初始化：是
 * 是否多线程安全：是
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 */
public class LazyTwo {
    private static LazyTwo lazy = null;

    private LazyTwo() {
    }

    //synchronized影响速度 性能问题
    public synchronized static final LazyTwo getInstance() {
        if (lazy == null) {
            lazy = new LazyTwo();
        }
        return lazy;
    }


}
