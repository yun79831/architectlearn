package com.learn.patten.singleton.lazy;

/**
 * 双重校验锁
 * Created by admin on 2018/3/11.
 * 是否 Lazy  初始化：是
 * 是否多线程安全：是
 */
public class LazyFour {

    private volatile static LazyFour lazy = null;

    private LazyFour() {
    }

    public static final LazyFour getInstance() {
        if (lazy == null) {
            synchronized (LazyFour.class) {
                if (lazy == null) {
                    //volatile解决指令重排问题
                    lazy = new LazyFour();
                }
            }
        }
        return lazy;
    }
}
