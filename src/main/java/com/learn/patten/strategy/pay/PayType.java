package com.learn.patten.strategy.pay;

/**
 * Created by admin on 2018/3/11.
 */
public enum PayType {
    ALI_PAY(new AliPay()), WECHAT(new WechatPay());
    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }
}
