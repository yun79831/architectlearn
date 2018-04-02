package com.learn.patten.template.demo2;

/**
 * Created by admin on 2018/3/31.
 */
public class BouilliDish2 {

    private DoDishTemp2 doDishTemp2 = new DoDishTemp2();

    public void doing() {
        doDishTemp2.doDish(new DoFaction() {
            public void doDish() {
                System.out.println("师傅在做红烧肉");
            }
        });
    }

}
