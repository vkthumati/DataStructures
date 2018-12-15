package com.thumati.ds.sortings;

public class SelectionSort {

	public static int[] selectionSort(int[] a) {
		int i, j, temp, min_index, n=a.length;
		for(i=0, min_index=0;i<n-1;++i, min_index=i) {
			//min_index = i;
			for(j=i+1;j<n;++j) {
				if(a[j] < a[min_index]) {
					min_index = j;
				}
			}
			temp = a[i];
			a[i] = a[min_index];
			a[min_index] = temp; 
		}
		return a;
	}
	
	public static void main(String[] args) {
		//int[] a = {64, 25, 12, 22, 11};
		for(int e : selectionSort(new int[]{64, 25, 12, 22, 11, 15, 9, 43, 3, 39})) {
			System.out.print(e+" ");
		}
	}

}
