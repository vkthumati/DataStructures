package com.thumati.ds.sortings;

/*
The below function always runs O(n^2) time even if the array is sorted. It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
 */
public class BubbleSort {

    public static void bubbleSort(int[] a){
        int i, j, temp;
        int n = a.length;
        boolean swapped;
        for(i = 0; i<n-1; ++i){
            swapped = false;
            for(j=0; j<n-i-1; ++j){
                if(a[j] > a[j+1]){
                    temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    swapped = true;
                }
            }
            //IF no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    public static void printArray(int[] a){
        for(int e : a){
            System.out.print(e+", ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        bubbleSort(a);
        printArray(a);
    }
}
