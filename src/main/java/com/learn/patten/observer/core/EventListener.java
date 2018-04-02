package com.learn.patten.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件注册监听器
 * Created by ghost on 2018-04-02.
 */
public class EventListener {
    protected Map<Enum, Event> events = new HashMap<Enum, Event>();

    //注册事件
    public void addListener(Enum e, Object target, Method method) {
        events.put(e, new Event(target, method));
    }

    //取消注册(关注)事件
    public void removerListener(Enum e) {
        events.remove(e);
    }

    //通知所有 观察者(方法形式或者对象形式)
    public void notifyObserver() {
        for (Enum key : events.keySet()) {
            trigger(events.get(key));
        }
    }


    //执行方法
    private void trigger(Event e) {
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

    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        Event e = this.events.get(call);
        e.setTrigger(call.toString());
        trigger(e);
    }

}
