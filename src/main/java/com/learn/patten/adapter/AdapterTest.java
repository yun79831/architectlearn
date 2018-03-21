package com.learn.patten.adapter;

import com.learn.patten.adapter.classada.ClassChargerAdapter;
import com.learn.patten.adapter.demo.ChinaCharger;
import com.learn.patten.adapter.objectada.ObjectChargerAdapter;
import org.junit.Test;
import org.objectweb.asm.ClassAdapter;

/**
 * 适配器模式
 * Created by ghost on 2018-03-21.
 */
public class AdapterTest {
    @Test
    public void ClassAdapterTest() {
        //类适配器,采用继承的形式
        ClassChargerAdapter classAdapter = new ClassChargerAdapter();
        classAdapter.voltage220V();
        classAdapter.voltage110V();
    }

    @Test
    public void objectAdapterTest() {
        //对象适配器 用法==装饰模式
        ChinaCharger chinaCharger = new ChinaCharger();
        ObjectChargerAdapter objectChargerAdapter = new ObjectChargerAdapter(chinaCharger);
        objectChargerAdapter.voltage220V();
        objectChargerAdapter.voltage110V();
    }
}
