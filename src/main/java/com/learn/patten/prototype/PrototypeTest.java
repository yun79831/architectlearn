package com.learn.patten.prototype;

import com.learn.patten.prototype.entity.CPU;
import com.learn.patten.prototype.entity.Computer;
import org.junit.Test;

/**
 * Created by admin on 2018/3/11.
 */
public class PrototypeTest {
    @Test

    public void test() throws Exception {


        CPU cpu = new CPU("2.5GHz", "i7");
        Computer computer = new Computer(cpu, "16G", "GTX1080Ti");
        //浅拷贝   clone的对象 构造函数不再执行
        Computer c1 = (Computer) computer.clone();
        System.out.println(computer==c1);
        System.out.println(computer.cpu==c1.cpu);//s


        //深拷贝
        Computer c2= computer.deepClone();
        System.out.println(c2==computer);
        System.out.println(c2.cpu==computer.cpu);



    }
}
