package com.learn.patten.singleton.lazy;

/**
 * 静态内部类
 * Created by admin on 2018/3/11.
 * 是否Lazy 初始化：是
 * 是否多线程安全：是
 */
public class LazyThree {
    private LazyThree() {
    }

    public static final LazyThree getInstance() {
        return LazyTool.LAZY;

    }

    private static class LazyTool {
        private static final LazyThree LAZY = new LazyThree();
    }
}
