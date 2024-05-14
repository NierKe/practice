package com.dk.sort;

import java.util.Arrays;

public class Sort {

    public static  void BubblesSort(int arr[]){
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void chooseSort(int arr[]){
    int maxIndex = 0;
        for (int i = 0;i < arr.length-1; i++) {
            maxIndex = 0;
            for (int j = 0; j < arr.length-i;j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
                int temp;
                temp = arr[maxIndex];
                arr[maxIndex] =  arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int arr[]){

        for(int i = 1;i<arr.length;i++){
            int j = i - 1;
            int temp = arr[i];
            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = temp;

        }
        System.out.println(Arrays.toString(arr));

    }


    public static void main(String[] args) {
        int arr[] = new int[]{10,1,25,18,0};
        //BubblesSort(arr);
       // chooseSort(arr);
        insertSort(arr);
    }
}
