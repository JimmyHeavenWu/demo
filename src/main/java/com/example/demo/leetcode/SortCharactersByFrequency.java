package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * Created by wuj42 on 8/9/2017.
 */
public class SortCharactersByFrequency {


    public String frequencySort(String s) {

        int [] map = new int[256];
        int max = 0;
        for(char c : s.toCharArray()) {
            map[c]++;
            if(map[c]>max) max = map[c];
        }

        String[] buckets = new String[max + 1];

        for(int i=0; i< 256; i++){
            String str = buckets[map[i]];
            if(map[i]>0){
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i = max; i>0 ; i--){
            if(buckets[i] != null) {
                for (char c : buckets[i].toCharArray()) {
                    for (int j = 0; j < i; j++) {
                        builder.append(c);
                    }
                }
            }
        }
        return  builder.toString();
    }


    public static void main(String [] args){
        String input = "abcaAbdbb";
        System.out.println(new SortCharactersByFrequency().frequencySort(input));
//        String expected_output = "bbbbaa"
    }
}
