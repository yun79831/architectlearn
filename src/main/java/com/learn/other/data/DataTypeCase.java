package com.learn.other.data;

/**
 * Created by admin on 2018/3/10.
 */
public class DataTypeCase {
    public static void main(String[] args) {
        //vm=-Djava.lang.Integer.IntegerCache.high=250 运行结果就不一致了
        Integer i1=128;
        Integer i2=128;   // -128到127  走缓存  从IntegerCache.cache中获取
        Integer i3=Integer.valueOf(128);
        Integer i4=new Integer(128);
        Integer t1=127;
        Integer t2=127;
        Integer t3=new Integer(127);
        System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i1==i4);
        System.out.println(i3==i4);

        System.out.println(t1==t2);
        System.out.println(t1==t3);
    }

}
