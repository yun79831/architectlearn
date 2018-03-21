package com.learn.patten.decorator;

import com.learn.patten.decorator.old.AccountService;
import com.learn.patten.decorator.old.AccountServiceImpl;
import com.learn.patten.decorator.upgrade.AccountUpgradeService;
import com.learn.patten.decorator.upgrade.AccountUpgradeServiceImpl;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * 装饰器模式
 * Created by admin on 2018/3/17.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //装饰器模式 实际上是一种用非常特殊的适配器模式
/*
                =====================================================================
                装饰器模式                         |   适配器模式
                -----------------------------------+---------------------------------
                是一种非常特别的适配器模式         |  可以不保留层级关系
                -----------------------------------+---------------------------------
                装饰者和被装饰者都要实现同一个接口 |  适配者和被适配者没有必然的层级联系
                主要目的是为了扩展，依旧保留OOP关系|  通常采用代理或者继承形式进行包装
                -----------------------------------+----------------------------------
                满足is-a的关系                     |   满足has-a
                -----------------------------------+----------------------------------
                注重的是覆盖、扩展                 |   注重兼容、转换
                -----------------------------------+----------------------------------
                */
    }


    public void test() {
        AccountUpgradeService accountUpgradeService = new AccountUpgradeServiceImpl(new AccountServiceImpl());
        accountUpgradeService.registerOrLogin();
    }


    public void inputTest() {
        //为了某个实现类在不修改原始类的基础上进行动态地覆盖或者增加方法
        //该实现保持跟原有类的层级关系
        //采用装饰模式
        //装饰器模式实际上一种非常特殊的适配器模式

        //虽然 DataInputStream 功能更强大
        //DataInputStream 同样要实现InputStream
        InputStream in = null;
        FilterInputStream fis = new DataInputStream(in);
    }


}
