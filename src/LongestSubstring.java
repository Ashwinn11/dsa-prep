package org.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String input = "pwwkew";
        int result = answer(input);
        System.out.println(result);
    }

    private static int answer(String input) {
        int j =0;
        int max =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<input.length();i++){
            char ch = input.charAt(i);
            if(map.containsKey(ch)){
                j =map.get(ch)+1;
            }
            map.put(ch,i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
