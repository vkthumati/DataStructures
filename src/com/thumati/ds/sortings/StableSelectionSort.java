package com.thumati.ds.sortings;

/**
 * Example: 4A 5 3 2 4B 1
 * First minimum element is 1, now instead of swapping. Insert 1 in its correct place and pushing every element one step forward i.e forward pushing.
 * 1 4A 5 3 2 4B
 * Next minimum is 2 : 1 2 4A 5 3 4B
 * Next minimum is 3 : 1 2 3 4A 5 3  2 4B
 * Repeat the steps until array is sorted. 1 2 3 4A 4B 5
 */
public class StableSelectionSort {

    public static void stableSelectionSort(int[] a){
        int i, j, minIndex, key, n=a.length;
        for(i=0; i<n-1; ++i){
            minIndex = i;
            for(j=i+1; j<n; ++j){
                if(a[j] < a[minIndex]){
                    minIndex = j;
                }
            }

            key = a[minIndex];

            while(minIndex > i){
                a[minIndex] = a[minIndex-1];
                minIndex--;
            }

            a[i] = key;
        }
    }

    public static void printArray(int[] a){
        for(int e : a){
            System.out.println(e+", ");
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 3, 2, 4, 1};
        stableSelectionSort(a);
        printArray(a);
    }

}
