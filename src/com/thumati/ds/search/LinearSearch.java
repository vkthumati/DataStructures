package com.thumati.ds.search;

import java.util.Random;

public class LinearSearch {

	public static int linearSearch(int[] a, int x) {
		for(int i=0;i<a.length;++i) {
			if(a[i]==x) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = new int[1500000];
		Random rn = new Random();
		for(int i=0;i<a.length;++i) {
			a[i] = rn.nextInt();
			System.out.println(a[i]+", ");
		}
		int index = linearSearch(a, a[1499999]);
		System.out.println("\n\nLinear Search Index : "+index);
		System.out.println("\n\nLinear Search value : "+a[index]);
	}

}
