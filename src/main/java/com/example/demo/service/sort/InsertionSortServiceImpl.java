package com.example.demo.service.sort;

import org.springframework.stereotype.Service;

/**
 * Created by Jimmy on 2017/6/20.
 */
@Service
public class InsertionSortServiceImpl implements SortService {

    private final String type = "InsertionSort";

    @Override
    public boolean canDo(String type) {
        return type.equalsIgnoreCase(this.type);
    }

    @Override
    public int[] sortNumbers(int[] unsortedList) {
        for (int i = 1; i < unsortedList.length; i++){
            int insertedNumber = unsortedList[i];
            for(int j = i-1; j >= 0 && unsortedList[j] >= insertedNumber;j--){
                int temp = unsortedList[j];
                unsortedList[j] = insertedNumber;
                unsortedList[j+1] = temp;
            }
        }
        return unsortedList;
    }

}
