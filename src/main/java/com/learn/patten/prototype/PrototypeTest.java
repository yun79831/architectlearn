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
        //浅克隆
        Computer c1 = (Computer) computer.clone();
        System.out.println(computer == c1);
        System.out.println(computer.cpu == c1.cpu);
    }


    @Test
    public void testDeepClone() {
        CPU cpu = new CPU("2.5GHz", "i7");
        Computer computer = new Computer(cpu, "16G", "GTX1080Ti");
        //深克隆
        Computer c2 = computer.deepClone();
        System.out.println(c2 == computer);
        System.out.println(c2.cpu == computer.cpu);
    }


}
