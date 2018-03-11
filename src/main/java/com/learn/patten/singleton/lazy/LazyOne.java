package com.learn.patten.singleton.lazy;

/**
 * 懒汉模式 非线程安全
 * Created by admin on 2018/3/10.
 * 是否 LazyTwo 初始化：是
 * 是否多线程安全：否
 * 并发时容易造成对象为null 多次赋值
 */
public class LazyOne {
    private static LazyOne lazy = null;

    private LazyOne() {
    }

    public static final LazyOne getInstance() {
        //并发时容易造成对象为null 多次赋值
        if (lazy == null) {
            lazy = new LazyOne();
        }
        return lazy;
    }


}
