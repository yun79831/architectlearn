package com.learn.patten.template.demo2;

/**
 * 做菜的模板
 * Created by ghost on 2018-03-21.
 */
public class DoDishTemp2 {
    public void doDish(DoFaction doFaction) {
        preparation();//准备
        doFaction.doDish();//做菜
        carriedDishes();//上菜
    }

    //准备调料
    private void preparation() {
        System.out.println("配菜师准备食材");
    }


    //上菜
    private void carriedDishes() {
        System.out.println("服务员上菜");
    }
}
