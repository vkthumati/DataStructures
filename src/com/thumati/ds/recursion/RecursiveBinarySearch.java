package com.thumati.ds.recursion;

public class RecursiveBinarySearch {
	private static int[] a;
	private static int count;
	/*public static int recursiveBinarySearch(int p, int r, int x) {
		int q = 0;
		if(!(p<=r)) {
			return -1;
		}else if(p<=r) {
			q = (p+r)/2;
			if(x<a[q]) {
				r = q-1;
			}else if(x>a[q]) {
				p = q+1;
			}else if(a[q]==x){
				return q;
			}
		}
		return recursiveBinarySearch(p, r, x);
	}*/
	
	public static int recursiveBinarySearch(int p, int r, int x) {
		System.out.println(++count+" - ["+p+"..."+r+"]");
		if(p>r){
			return -1;
		}else{
			int q = (p + r) / 2;
			if (a[q] == x) {
				return q;
			}else if (x < a[q]) {
				return recursiveBinarySearch(p, q-1, x);
			} else {
				return recursiveBinarySearch(q+1, r, x);
			} 
		}
	}
	
	public static void main(String[] args) {
		a = new int[100000000];
		for(int i=0; i<100000000;i++) {
			a[i] = i+1;
		}
		
		int index = recursiveBinarySearch(0, a.length-1, 100000000);
		System.out.println("The index and value : "+index+" - "+a[index]);
	}

}
