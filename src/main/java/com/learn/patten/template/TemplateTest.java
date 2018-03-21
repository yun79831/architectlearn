package com.learn.patten.template;

import com.learn.patten.template.demo.BouilliDish;
import com.learn.patten.template.demo.DoDishTemp;
import com.learn.patten.template.demo.SymplecticNoodlesDish;
import org.junit.Test;

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
}
