package com.learn.patten.observer.subject;

/**
 * 观察者
 * Created by ghost on 2018-04-02.
 */
public class EventObserver {
    //观察者处理方法
    public void onAdd(Event e) {
        System.out.println("被观察者调用了add方法");
    }

    //观察者处理方法
    public void onEdit(Event e) {
        System.out.println("被观察者调用了edit方法");
    }

    //观察者处理方法
    public void onRemover(Event e) {
        System.out.println("被观察者调用了remover方法");
    }
}
