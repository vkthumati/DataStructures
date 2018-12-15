package com.thumati.ds.recursion;

public class RecursiveLinearSearch {
	private static int[] a;
	
	public static int recursiveLinearSearch(int i, int x) {
		if(i<0 || i>a.length-1) {
			return -1;
		}else if(a[i]==x) {
			System.out.println(x+" is at the Index : "+i);
			return i;
		}else {
			System.out.println("Index at : "+i);
			return recursiveLinearSearch(++i, x);
		}
	}
	
	public static void main(String[] args) {
		a = new int[5000];
		for(int i=0; i<5000;i++) {
			a[i] = i+1;
		}
		
		recursiveLinearSearch(0, 5000);
	}

}

