package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuj42 on 8/4/2017.
 */
public class Solution {
    private char [] firstRow = {'q','w','e','r','t','y','u','i','o','p'};
    private char [] secondRow = {'a','s','d','f','g','h','j','k','l'};
    private char [] thirdRow = {'z','x','c','v','b','n','m'};
    private Map<Character, Integer> keys = new HashMap<>();

    public String[] findWords(String[] words) {
        init();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(isTypedInOneLine(words[i])){
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public boolean isTypedInOneLine(String word){
        char [] characters = word.toLowerCase().toCharArray();
        boolean isInOneLine = true;
        int rowOfFirstChar = keys.get(characters[0]);
        for(int i=1; i<characters.length; i++){
            if(keys.get(characters[i]) != rowOfFirstChar){
                return false;
            }
        }
        return isInOneLine;
    }

    public void init(){
        for(int i=0; i<firstRow.length; i++){
            keys.put(firstRow[i], 1);
        }
        for(int i=0; i<secondRow.length; i++){
            keys.put(secondRow[i], 2);
        }
        for(int i=0; i<thirdRow.length; i++){
            keys.put(thirdRow[i], 3);
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String [] words = {"Hello","Alaska","Dad","Peace"};
        s.findWords(words);
    }
}
