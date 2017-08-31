package com.example.demo.classLoader;

/**
 * Created by wuj42 on 8/25/2017.
 */
public class Air {
    static {
        System.out.println("Air static block");
    }

    public Air(){
        System.out.println("Air start");
    }
}
