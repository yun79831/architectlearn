package com.learn.patten.observer.proxy;

import com.learn.patten.observer.subject.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽离 被观察者中一对多的关系
 * 添加监听,绑定对象关系和触发目标
 * Created by ghost on 2018-04-02.
 */
public class MouseListener  {
    Map<String, MouseEvent> eventMap = new HashMap<String, MouseEvent>();

    //注册监听
    public void addListener(String key, Object target, Method method) {
        eventMap.put(key, new MouseEvent(target, method));
    }

    //移除监听
    public void removeListener(String key) {
        if (eventMap.containsKey(key)) {
            eventMap.remove(key);
        }
    }

    //通知所有 观察者
    public void notifyObserver() {
        for (String key : eventMap.keySet()) {
            trigger(key);
        }
    }

    //执行方法
    public void trigger(String call) {
        if (!this.eventMap.containsKey(call)) {
            return;
        }
        MouseEvent e = this.eventMap.get(call);
        e.setTrigger(call.toString());
        e.setSource(this);
        e.setTime(System.currentTimeMillis());
        try {
            e.getMethod().invoke(e.getTarget(), e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

}
