package com.thumati.ds.sortings;

public class InsertionSort {

/*	public static int[] insertionSort(int[] a) {
		int i, j, min_value, n=a.length;
		for(i=0; i<n-1;++i) {
			for(j=i+1;j>0;--j) {
				if(a[j]<a[j-1]) {
					min_value = a[j];
					a[j]=a[j-1];
					a[j-1]=min_value;
				}
			}
		}
		return a;
	}
*/
	/*public static int[] insertionSort(int[] a) {
		int i, j, min_value, n=a.length;
		for(i=0; i<n-1;++i) {
			for(j=i+1;j>0&&a[j]<a[j-1];--j) {
				min_value = a[j];
				a[j]=a[j-1];
				a[j-1]=min_value;
			}
		}
		return a;
	}*/
	
/*	public static int[] insertionSort(int[] a) {
		int i, j, min_value, n = a.length;
		for (i = 0; i < n - 1; ++i) {
			j = i+1;
			min_value = a[j];
			while (j >0 && min_value < a[j - 1]) {
				a[j] = a[j - 1];
				j = j-1;
			}
			a[j] = min_value;
		}
		return a;
	}*/

	public static int[] insertionSort(int[] a) {
		int i, j, key, n = a.length;
		for (i = 1; i < n; ++i) {
			key = a[i];
			j = i-1;
			/* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
			while (j>=0 && a[j]>key) {
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = key;
		}
		return a;
	}

	public static void main(String[] args) {
		for(int e : insertionSort(new int[] {4,3,2,10,12,1,5,6})) {
			System.out.println(e+" ");
		}

	}

}
