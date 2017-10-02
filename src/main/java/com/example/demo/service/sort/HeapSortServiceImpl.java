package com.example.demo.service.sort;

import org.springframework.stereotype.Service;

/**
 * Created by Jimmy on 2017/9/7.
 */
@Service
public class HeapSortServiceImpl implements SortService {
    @Override
    public String getSortAlgorithmName() {
        return "heapSort";
    }

    @Override
    public int[] sortNumbers(int[] unsortedList) {

        int startIndex = (unsortedList.length -1)/2;

        int length = unsortedList.length;

        for(int i = startIndex; i>=0; i--){
            maxHeap(unsortedList, i, length);
        }

        for(int i = unsortedList.length -1; i>=0; i--){
            int temp = unsortedList[0];
            unsortedList[0] = unsortedList[i];
            unsortedList[i] = temp;
            length--;
            maxHeap(unsortedList, 0, length);
        }

        return unsortedList;
    }

    public void maxHeap(int[] heap, int index, int heapSize){
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        int max = index;

        if(leftIndex < heapSize && heap[leftIndex] > heap[index]){
            max = leftIndex;
        }

        if(rightIndex < heapSize && heap[rightIndex] > heap[max]){
            max = rightIndex;
        }

        if(max != index){
            int temp = heap[index];
            heap[index] = heap[max];
            heap[max] = temp;
        }else{
            return;
        }

        maxHeap(heap, max, heapSize);

    }

    public int leftChild(int index){
        return index*2+1;
    }

    public int rightChild(int right){
        return right*2+2;
    }
}
