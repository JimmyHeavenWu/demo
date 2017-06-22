package com.example.demo.service.sort;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by wuj42 on 6/21/2017.
 */
@Service
public class MergeSortServiceImpl implements SortService {

    private final String type = "mergeSort";

    @Override
    public boolean canDo(String type) {
        return type.equalsIgnoreCase(this.type);
    }

    @Override
    public int[] sortNumbers(int[] unsortedList) {
        int middleIndex = unsortedList.length/2;

        if(unsortedList.length <= 1){
            return unsortedList;
        }

        int[] left = sortNumbers(Arrays.copyOfRange(unsortedList, 0, middleIndex ));
        int[] right = sortNumbers(Arrays.copyOfRange(unsortedList, middleIndex, unsortedList.length));

        return mergeAction(left,right);
    }

    private int[] mergeAction(int[] left, int[] right){
        assert(left.length > 0);
        assert(right.length > 0);

        int totalSize = left.length + right.length;
        int[] sortedNumbers = new int[totalSize];

        int leftIndex =0;
        int rightIndex = 0;

        for(int  i=0; i< totalSize; i++){

            if(leftIndex >= left.length && rightIndex < right.length){
                sortedNumbers[i] = right[rightIndex];
                rightIndex++;
                continue;
            }

            if(rightIndex >= right.length && leftIndex < left.length){
                sortedNumbers[i] = left[leftIndex];
                leftIndex++;
                continue;
            }

            if(left[leftIndex] <= right[rightIndex]){
                sortedNumbers[i] = left[leftIndex];
                leftIndex++;
            }else{
                sortedNumbers[i] = right[rightIndex];
                rightIndex++;
            }
        }

        return  sortedNumbers;
    }

}
