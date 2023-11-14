package org.core;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum{
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(method1(nums,target)));
    }
    public static int[] method1 (int[] nums , int target){
        int[] answer = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        int j =0;
        for (int i =0;i<nums.length;i++){
            int rem = target - nums[i];
            if (map.containsKey(rem)){
                answer[j++]=i;
                answer[j]=map.get(rem);
                return answer;
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
