package com.dk.leetcode;



import org.jetbrains.annotations.NotNull;

import java.util.*;

import static java.lang.Math.max;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * **/
public class LeetCode3 {
    public static void main(String[] args) {
        String s = "hhhsadsafasgsdgassdg";
        Set<Character> charSet = new HashSet<>();
        ArrayList list = new ArrayList();
        Arrays.asList("1","2");
        list.add(1);list.add(2);list.add(3);
        list.remove(1);
        int left = 0;
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = i;
            if(left > 0){
                charSet.remove(s.charAt(i-1));
            }
            while(!charSet.contains(s.charAt(i+1))){

            }
        }
//        int maxLength = 0;
//        List<Character> st = new ArrayList<>();
//        String maxLengthStr = "";
//        int start = -1;
//        for(int left = 0;left < s.length();left++){
//            if(left != 0){
//                st.remove((Character)s.charAt(left - 1));
//            }
//            while(start < s.length() -1 && !st.contains(s.charAt(start+1))){
//                st.add(s.charAt(start+1));
//                ++start;
//            }
//            maxLength = Math.max(maxLength,start - left + 1 );
//            String s1 = strArrayToString(st);
//            if(s1.length() > maxLengthStr.length()){
//                maxLengthStr = s1;
//            }
//        }
//        System.out.println(maxLengthStr);
    }

    private static String strArrayToString(List<Character> list){
        String str = "";
        for(int i = 0;i<list.size();i++){
            str = str + list.get(i);
        }
        return str;
    }

}
