package com.learn.patten.strategy.pay;

import com.learn.patten.strategy.entity.PayState;

/**
 * 策略模式中各种策略需要有一个共同的基类
 * Created by admin on 2018/3/11.
 */
public interface Payment {
    PayState pay(String orderId, Double amount);

}
