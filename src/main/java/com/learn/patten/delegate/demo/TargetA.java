package com.learn.patten.delegate.demo;

/**
 * Created by admin on 2018/3/31.
 */
public class TargetA  implements ITarget{
    public void doing(String command) {
        System.out.println("员工A 开始进行"+command+"工作");

    }
}
