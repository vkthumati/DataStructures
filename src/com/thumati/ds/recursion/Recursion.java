package com.thumati.ds.recursion;

public class Recursion {
	int count;
	public void foo() {
		try {
			count++;
			foo();
		}catch (Error e) {
			System.out.println("StackOverFlowError has occured at the count : "+count);
			
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Recursion r = new Recursion();
		r.foo();
	}

}
