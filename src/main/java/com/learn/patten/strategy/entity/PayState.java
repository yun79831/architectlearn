package com.learn.patten.strategy.entity;

/**
 * Created by admin on 2018/3/11.
 */
public class PayState {
    public int code;
    public String data;
    public String msg;

    public PayState(int code, String data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
