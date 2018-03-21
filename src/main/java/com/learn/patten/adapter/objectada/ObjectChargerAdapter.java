package com.learn.patten.adapter.objectada;

import com.learn.patten.adapter.demo.ChinaCharger;

/**
 * 对象模式适配器
 * Created by ghost on 2018-03-21.
 */
public class ObjectChargerAdapter {
    private ChinaCharger chinaCharger;

    public ObjectChargerAdapter(ChinaCharger chinaCharger) {
        this.chinaCharger = chinaCharger;
    }

    public void voltage220V() {
        chinaCharger.voltage220V();
    }

    //适配外国110V
    public void voltage110V() {
        System.out.println("美国110V电压充电器");
    }
}
