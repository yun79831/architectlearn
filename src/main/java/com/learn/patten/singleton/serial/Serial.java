package com.learn.patten.singleton.serial;

import java.io.Serializable;

/**
 * 反序列化时导致单例破坏
 * Created by admin on 2018/3/11.
 */
public class Serial implements Serializable {
    private static final Serial SERIAL = new Serial();

    private Serial() {
    }

    public static final Serial getInstance() {
        return SERIAL;
    }
}
