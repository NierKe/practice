package com.dk.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    //问题：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    public static int[] getIndex(int arr[],int target){
        Map<Integer,Integer> map = new HashMap<>();
       for(int i = 0 ;i< arr.length;i++){
           if(map.containsKey(target - arr[i])){
               return new int[]{i, map.get(target - arr[i])};
           }else{
               map.put(arr[i],i);
           }

       }
       return new int[2];
    }


    public static void main(String[] args) {
        int arr[] = new int[]{10,1,25,18,0};
        System.out.println(Arrays.toString(getIndex(arr,10)));
    }
}
