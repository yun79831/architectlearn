package com.learn.patten.prototype.entity;

import java.io.*;

/**
 * Created by admin on 2018/3/11.
 */
public class Computer implements Cloneable, Serializable {
    public CPU cpu;
    public String memory;
    public String Graphics;

    public Computer() {
        System.out.println("执行computer构造函数0");
    }

    public Computer(CPU cpu, String memory, String graphics) {
        this.cpu = cpu;
        this.memory = memory;
        Graphics = graphics;
        System.out.println("执行computer构造函数");
    }

    @Override
    //浅拷贝
    public Object clone() throws CloneNotSupportedException {
        //clone 构造函数不再执行
        return super.clone();
    }

    public Computer deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Computer c = (Computer) ois.readObject();
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
