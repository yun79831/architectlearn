package com.learn.patten.observer.subject;

import com.learn.patten.observer.core.EventListener;

/**
 * 被观察者
 * Created by ghost on 2018-04-02.
 */
public class Subject extends EventListener {
    public void add() {
        System.out.println("调用添加方法");
        trigger(SubjectType.ADD);
    }

    public void edit() {
        System.out.println("调用编辑方法");
        trigger(SubjectType.EDIT);
    }

    public void remover() {
        System.out.println("调用删除方法");
        trigger(SubjectType.REMOVER);
    }


    public void sendAll() {
        System.out.println("通知所有观察方法");
        notifyObserver();
    }
}
