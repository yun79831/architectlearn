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
    //浅克隆
    public Object clone() throws CloneNotSupportedException {
        //  实现Cloneable接口  通过clone()克隆 构造函数不再执行
        return super.clone();
    }

    //深克隆
    public Computer deepClone() {
        //实现序列化接口通过字节数组流和对象流进行克隆
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
