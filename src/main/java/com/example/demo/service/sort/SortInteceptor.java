package com.example.demo.service.sort;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Jimmy on 2017/7/18.
 */
@Aspect
@Component
public class SortInteceptor {

    @Before("execution(* com.example.demo.service.sort.SortService.sortNumbers(..)) && args(unsortedList)")
    public void beforeMethod(int [] unsortedList){
        System.out.println("before something");
        System.out.println("list's length is " + unsortedList.length);
    }


}
