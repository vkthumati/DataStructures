package com.thumati.ds.sortings;

public class MySelectionSort {

    public static void selectionSort(int[] a){
        int i, j, temp, n = a.length;
        int minIndex = 0;

        // One by one move boundary of unsorted subarray
        for(i=0; i<n-1; ++i){
            // Find the minimum element in unsorted array
            minIndex = i;
            for(j=i+1; j<n; ++j){
                if(a[j] < a[minIndex])
                    minIndex = j;
            }

            // Swap the found minimum element with the first element
            if(minIndex > i) {
                temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    public static void printArray(int[] a){
        for(int e : a){
            System.out.print(e+", ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 6, 6, 11};
        //int[] a = {64, 25, 12, 22, 11};
        //int[] a = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 11};
        selectionSort(a);
        printArray(a);
    }
}
