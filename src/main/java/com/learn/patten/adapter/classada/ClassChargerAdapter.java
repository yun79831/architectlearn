package com.learn.patten.adapter.classada;

import com.learn.patten.adapter.demo.ChinaCharger;
import com.learn.patten.adapter.demo.TargetCharger;

/**
 * 充电器适配器   适配器耦合性比较强
 * Created by ghost on 2018-03-21.
 */
public class ClassChargerAdapter extends ChinaCharger implements TargetCharger {
    public void voltage110V() {
        System.out.println("美国110V电压充电器");
    }
}
