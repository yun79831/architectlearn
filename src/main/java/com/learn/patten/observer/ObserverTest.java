package com.learn.patten.observer;

import com.learn.patten.observer.core.Event;
import com.learn.patten.observer.subject.Observer;
import com.learn.patten.observer.subject.Subject;
import com.learn.patten.observer.subject.SubjectType;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by ghost on 2018-04-02.
 */
public class ObserverTest {
    @Test
    public void subjectObserver() {
        //1.被观察者中包含观察者的一对多的集合            可以提供添加,删除,通知的所有操作
        //2.观察者拿到观察者的对象,调用观察者的方法


        Observer observer = new Observer();
        try {
            Method add = Observer.class.getMethod("onAdd", new Class<?>[]{Event.class});
            Method edit = Observer.class.getMethod("onEdit", new Class<?>[]{Event.class});
            Method remover = Observer.class.getMethod("onRemover", new Class<?>[]{Event.class});
            Subject subject = new Subject();
            subject.addListener(SubjectType.ADD, observer, add);
            subject.addListener(SubjectType.EDIT, observer, edit);
            subject.sendAll();
            subject.add();
            subject.remover();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
