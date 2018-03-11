package com.learn.patten.strategy.entity;

import com.learn.patten.strategy.pay.PayType;
import com.learn.patten.strategy.pay.Payment;

/**
 * Created by admin on 2018/3/11.
 */
public class Order {
    public String uid;
    public String orderId;
    public double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(PayType payType) {
        return payType.get().pay(orderId, amount);
    }
}
