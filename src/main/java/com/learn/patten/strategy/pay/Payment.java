package com.learn.patten.strategy.pay;

import com.learn.patten.strategy.entity.PayState;

/**
 * Created by admin on 2018/3/11.
 */
public interface Payment {
    Payment ALI_PAY = new AliPay();
    Payment WECHAT_PAY = new WechatPay();
    PayState pay(String orderid,Double amount);

}
