package com.learn.patten.template;

import com.learn.patten.template.demo.BouilliDish;
import com.learn.patten.template.demo.DoDishTemp;
import com.learn.patten.template.demo.SymplecticNoodlesDish;
import com.learn.patten.template.demo2.BouilliDish2;
import com.learn.patten.template.demo2.DoDishTemp2;
import com.learn.patten.template.demo2.DoFaction;
import com.learn.patten.template.demo3.dao.UserDao;
import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Created by admin on 2018/3/11.
 */
public class TemplateTest {
    @Test
    public void test() {
        DoDishTemp bouilliDish = new BouilliDish();
        bouilliDish.doDish();
        DoDishTemp symplecticNoodlesDish = new SymplecticNoodlesDish();
        symplecticNoodlesDish.doDish();
    }

    @Test
    public void test2() {
        //
        BouilliDish2 dish2 = new BouilliDish2();
        dish2.doing();
//        DoDishTemp2 d2 = new DoDishTemp2();
//        d2.doDish(new DoFaction() {
//            public void doDish() {
//                System.out.println("师傅在做红烧肉");
//            }
//        });
    }


    @Test
    public void jdbctTest() {
        UserDao userDao = new UserDao();
        userDao.query();
    }
}
