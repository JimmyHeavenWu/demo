package com.example.demo.classLoader;

/**
 * Created by wuj42 on 8/25/2017.
 */
public class Dog extends Animal {
    public static Air air = new Air();
    public static final int a = 0;

    static {
        System.out.println("Dog static block");
    }
    {
        System.out.println("Dog non-static block");
    }

    public Dog(int age) {
//        super(age);
        System.out.println("Dog start");
        eat();
        System.out.println("Dog end");
    }

    @Override
    public void eat(){
        System.out.println("Dog.eat");
    }

}

