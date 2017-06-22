package com.example.demo.service.sort;


/**
 * Created by Jimmy on 2017/6/20.
 */
public interface SortService {

    boolean canDo(String type);

    int[] sortNumbers(int[] unsortedList);

}
