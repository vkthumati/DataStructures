package com.thumati.ds.sortings;

public class InsertionSort1 {
	
	public static int[] insertionSort(int[] a) {
		int i, j, min, n=a.length;
		for(i=1;i<n;++i) {
			min=a[i];
			j=i-1;
			while(j>=0 && a[j]>min) {
				a[j+1]=a[j];
				--j;
			}
			a[j+1]=min;
		}
		return a;
	}

	public static void main(String[] args) {
		for(int e : insertionSort(new int[] {6,1,5,2,4,3,8,7})) {
			System.out.println(e+" ");
		}

	}

}
