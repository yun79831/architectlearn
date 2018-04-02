package com.learn.patten.observer;

import com.learn.patten.observer.proxy.*;
import com.learn.patten.observer.subject.Event;
import com.learn.patten.observer.subject.EventObserver;
import com.learn.patten.observer.subject.Subject;
import com.learn.patten.observer.subject.SubjectType;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ghost on 2018-04-02.
 */
public class ObserverTest {
    @Test
    public void subjectObserver() {
        //1.被观察者中包含观察者的一对多的集合            可以提供添加,删除,通知的所有操作
        //2.观察者拿到观察者的对象,调用观察者的方法
        EventObserver eventObserver = new EventObserver();
        try {
            Method add = EventObserver.class.getMethod("onAdd", new Class<?>[]{Event.class});
            Method edit = EventObserver.class.getMethod("onEdit", new Class<?>[]{Event.class});
            Method remover = EventObserver.class.getMethod("onRemover", new Class<?>[]{Event.class});
            Subject subject = new Subject();
            subject.addListener(SubjectType.ADD, eventObserver, add);
            subject.addListener(SubjectType.EDIT, eventObserver, edit);
            subject.sendAll();
            subject.add();
            subject.remover();
            subject.sendAll();//通知所有方法

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void proxyTest() {
        try {

            IMouseObserver logMouseObserver = new LogMouseObserver();//精确到了观察者方法级别
            Method action = LogMouseObserver.class.getMethod("action", new Class<?>[]{MouseEvent.class});
            IMouseObserver repMouseObserver = new RepairMouseObserver();
            Method repMouseObserverAction = RepairMouseObserver.class.getMethod("action", new Class<?>[]{MouseEvent.class});
            MouseHandler mouseHandler = new MouseHandler();
            mouseHandler.addListener("click", logMouseObserver, action);
            mouseHandler.addListener("move", repMouseObserver, repMouseObserverAction);

            IMouse mouse = (IMouse) mouseHandler.newInstence(new Mouse());
            mouse.click();
            mouse.move();
            mouseHandler.removeListener("move");
            mouse.move();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
