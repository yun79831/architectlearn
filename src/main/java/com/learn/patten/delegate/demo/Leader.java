package com.learn.patten.delegate.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/3/31.
 */
public class Leader implements ITarget {
    private Map<String, ITarget> targetMap = new HashMap<String, ITarget>();

    public Leader() {
        targetMap.put("登录", new TargetA());
        targetMap.put("注册", new TargetB());
    }

    public void doing(String command) {
        targetMap.get(command).doing(command);
    }
}
