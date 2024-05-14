package com.dk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组**/
public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = new int[]{-1,-1,0,1,2,2,3,4,-1,-4,-5,-6};
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length ; i++) {
            int L = i+1;
            int R = arr.length-1;
            if(arr[i] > 0){
                System.out.printf(res.toString());
                break;
            }
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            while(L < R){
                int sum = arr[i] + arr[L] + arr[R];
                if(sum == 0){
                    res.add(Arrays.asList(arr[i],arr[L],arr[R]));
                    while (L < R && arr[L] == arr[L+1])
                        L++;
                    while(L < R && arr[R] == arr[R-1])
                        R--;
                    L++;
                    R--;
                }
                if(sum > 0)
                    R--;
                if(sum < 0)
                    L++;
            }
        }
    }
}
