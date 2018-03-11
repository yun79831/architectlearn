package com.learn.patten.strategy.pay;

import com.learn.patten.strategy.entity.PayState;

/**
 * Created by admin on 2018/3/11.
 */
public class AliPay implements Payment {
    public PayState pay(String orderId, Double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("查询余额开始扣款");
        return new PayState(200, "账单号" + orderId + " 金额:" + amount, "支付成功");
    }
}
