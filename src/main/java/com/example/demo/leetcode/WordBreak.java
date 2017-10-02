package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2017/9/7.
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {


        for(int i=0; i< s.length(); i++){
            if(i==0 && wordDict.contains(s)) return true;
            String left = s.substring(0,i);
            String right = s.substring(i, s.length());
            if(wordDict.contains(left) && wordBreak(right,wordDict)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String [] args){
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        System.out.println(wordBreak("leetcode", dict));

    }
}
