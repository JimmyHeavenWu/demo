package com.example.demo.classLoader;

/**
 * Created by wuj42 on 8/25/2017.
 */
public abstract class Animal {
    public int age = 0;
    static {
        System.out.println("Animal static block");
    }
    {
        System.out.println("Animal non-static block");
    }

    public Animal(int age){
        System.out.println("Animal start");
        this.age = age;
        System.out.println("age:" + age);
        eat();
        System.out.println("Animal end");
    }

    public void eat(){
        System.out.println("Animal.eat");
    }

}
