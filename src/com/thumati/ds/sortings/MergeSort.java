package com.thumati.ds.sortings;

public class MergeSort {

	public void mergeSort(int[] a, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(a, p, q);
			mergeSort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public void merge(int[] a, int p, int q, int r) {
		
	}
	
	public static void main(String[] args) {
		int[] a = {9,7,3,1,6,3,2,6,8,9,2,3,0};

		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(a, 0, a.length-1);
		
		for(int e : a) {
			System.out.println(e+" ");
		}
	}

}
