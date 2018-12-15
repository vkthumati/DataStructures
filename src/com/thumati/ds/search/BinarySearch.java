package com.thumati.ds.search;

public class BinarySearch {
	
	public static int binarySearch(int[] a, int x) {
		int p = 0, r = a.length-1, q;
		while(p<=r) {
			q = (p+r)/2;
			if(x<a[q]) 
				r=q-1;
			else if(x>a[q])
				p=q+1;
			else 
				return q;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] {3, 7, 11, 15, 17, 19, 22, 26, 30, 33, 37, 41, 54, 56, 58, 60, 61, 63, 65, 67, 69, 70, 72, 74, 76, 78, 80, 81, 83, 85, 87, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
		System.out.println(a[binarySearch(a, 69)]);

	}

}
