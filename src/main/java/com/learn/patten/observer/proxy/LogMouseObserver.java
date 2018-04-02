package com.learn.patten.observer.proxy;

/**
 * 具体观察者 --记录日志的观察者
 * Created by ghost on 2018-04-02.
 */
public class LogMouseObserver implements IMouseObserver {
    //观察后的动作
    public void action(MouseEvent event) {
        System.out.println("LOG:" + System.currentTimeMillis() + " 进行了鼠标的" + event.getTrigger() + "操作");
    }
}
