package com.learn.patten.observer.proxy;

import java.lang.reflect.Method;

/**
 * Created by ghost on 2018-04-02.
 */
public class MouseEvent {
    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调方法
    private Method method;
    //触发
    private String trigger;
    //时间
    private long time;


    public MouseEvent(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
