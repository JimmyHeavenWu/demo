package com.example.demo.classLoader;

/**
 * Created by wuj42 on 8/25/2017.
 */
public class Singleton {

    private static Singleton singleTon = new Singleton();
    public static int count1;
    public static int count2 = 0;
    static {
        System.out.println(String.format("load singleTon:"+ singleTon + " count1:%d count:%d", count1, count2));
    }
    {
        System.out.println("load singleTon dynamic");
    }


    private Singleton() {
        System.out.println(String.format("initialize Singleton count1:%d count:%d", count1, count2));
        count1++;
        count2++;
    }

    public static Singleton getInstance() {
        System.out.println(String.format("getInstance count1:%d count:%d", count1, count2));
        return singleTon;
    }

    public static void main(String[] args) {
        Singleton singleTon = Singleton.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
