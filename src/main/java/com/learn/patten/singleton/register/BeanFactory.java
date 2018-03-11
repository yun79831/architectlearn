package com.learn.patten.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登记式
 * Created by admin on 2018/3/11.
 */
public class BeanFactory {
    private BeanFactory() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static final Object getBean(String className) {
        if (!ioc.containsKey(className)) {
            //双重检验解决并发问题
            synchronized (BeanFactory.class) {
                if (!ioc.containsKey(className)) {
                    try {
                        Object obj = Class.forName(className).newInstance();
                        ioc.put(className, obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ioc.get(className);
    }


}
