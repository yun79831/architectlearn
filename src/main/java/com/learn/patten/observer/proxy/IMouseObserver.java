package com.learn.patten.observer.proxy;

/**
 * 抽象观察者
 * Created by ghost on 2018-04-02.
 */
public interface IMouseObserver {
    //观察后的动作
    void action(MouseEvent event);

}
