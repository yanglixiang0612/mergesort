package com.itheima.bean;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = {5,4,9,8,7,6,0,1,3,2};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i++;
                index++;
            }else{
                temp[index] = arr[j];
                j++;
                index++;
            }
        }

        while(i <= mid){
            temp[index] = arr[i];
            i++;
            index++;
        }

        while(j <= high){
            temp[index] = arr[j];
            j++;
            index++;
        }

        //每归并一次新数组就会覆盖旧数组一部分元素(一共归并n-1次)
        for(int k = 0; k < temp.length; k++){
            arr[k+low] = temp[k];
        }
    }
}
