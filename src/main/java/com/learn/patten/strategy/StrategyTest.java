package com.learn.patten.strategy;

import com.learn.patten.strategy.entity.Order;
import com.learn.patten.strategy.pay.PayType;
import com.learn.patten.strategy.pay.Payment;
import org.junit.Test;

/**
 * 策略模式
 * Created by admin on 2018/3/11.
 */
public class StrategyTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Order order = new Order("1", "20112122", 50);
        //支付方式     微信,支付宝
        System.out.println(order.pay(PayType.WECHAT));
        System.out.println(order.pay(PayType.ALI_PAY));
    }
}
