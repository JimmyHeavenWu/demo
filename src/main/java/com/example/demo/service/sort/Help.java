package com.example.demo.service.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 26/09/2017.
 */
public class Help {


    public List<Integer> help(List<Integer> left, List<Integer> right){

        if(left == null) return right;
        if(right == null) return left;


        List<Integer> result = new ArrayList<>();
        int left_index = 0;
        int right_index = 0;

        while(left_index < left.size() || right_index < right.size()){

            if(right_index >= right.size() || (left.get(left_index) < right.get(right_index))){

                result.add(left.get(left_index));
                left_index++;

            }else if(left_index >= left.size() || (left.get(left_index) > right.get(right_index))) {

                result.add(right.get(right_index));
                right_index++;
            }else {
                left_index ++;
                right_index ++;
            }

        }

        return result;


    }


    public static void main(String[] args){

    }

}
