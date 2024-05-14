package com.dk.sort;

import java.util.Arrays;

public class Test {
    public static int[] BubbleSort(int arr[]){
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }


        return arr;
    }
    public static int[] simpleChoose(int arr[]){
        for (int i = 0 ; i < arr.length -1 ; i++) {
            int index = i;
            for(int j = i; j < arr.length ; j++){
                if(arr[j] < arr[index]){
                  index = j;
                }
            }
            int temp;
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

        }
        return arr;
    }



    public static int[] inserSort(int arr[]){
        for (int i = 1 ; i < arr.length  ; i++) {
            int j = i - 1;
            int temp;

            while(arr[j] > arr[i]){

            }

        }
        return arr;
    }



    public static void main(String[] args) {
    int arr[] = new int[]{1,23,4,55,23,7,0};
     //   System.out.println(Arrays.toString(BubbleSort(arr)));

        System.out.println(Arrays.toString(simpleChoose(arr)));
    }
}
