package com.learn.patten.observer.proxy;

/**
 * 具体观察者 --维修观察者
 * Created by ghost on 2018-04-02.
 */
public class RepairMouseObserver implements IMouseObserver {
    //观察后的动作
    public void action(MouseEvent event) {
        System.out.println("维修观察者:" + System.currentTimeMillis() + " 进行了鼠标的" + event.getTrigger() + "频率观察");
    }
}
