package com.example.demo.leetcode;

/**
 * Created by Jimmy on 2017/9/3.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum ^= nums[i];
        }
        return sum;
    }

    public static void main(String [] args){
        int[] numbers = {1};
        System.out.println(singleNumber(numbers));
    }

}
