package com.thumati.ds.sortings;

public class MergeSort {

	public static void divideConquer(int[] arr, int left, int right){
		if(left < right){
			int mid = (left+right)/2;

			divideConquer(arr, left, mid);
			divideConquer(arr, mid+1, right);

			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right){

		//Find sizes of two subarrays to be merged.
		int n1 = mid-left+1;
		int n2 = right-mid;

		//create temp arrays
		int[] L = new int[n1];
		int[] R = new int[n2];

		//copy data to temp arrays
		for(int i=0; i<n1; ++i)
			L[i] = arr[left+i];
		for(int j=0; j<n2; ++j)
			R[j] = arr[mid+j+1];

		//Merge the temp arrays

		// Initial indexes of first and second subarrays
		int i=0, j=0;

		// Initial index of merged subarry array
		int k=left;

		while(i<n1 && j<n2){
			if(L[i]<=R[j]){
				arr[k] = L[i];
				++i;
			}else{
				arr[k] = R[j];
				++j;
			}
			++k;
		}

		//Copy remaining elements of L[] if any
		while(i<n1){
			arr[k] = L[i];
			++i;
			++k;
		}

		//Copy remaining elements of R[] if any
		while(j<n2){
			arr[k] = R[j];
			++j;
			++k;
		}
	}

	public static void main(String[] args) {
		int[] arr = {12, 13, 11, 5, 6, 7};

		divideConquer(arr, 0, arr.length-1);

		for(int e : arr){
			System.out.print(e+" ");
		}
	}
}
