package com.thumati.ds.arraylist;

class Super{
	public void show() {
		System.out.println("Super :: show");
	}
}

public class Child extends Super{
	
	@Override
	public void show() {
		System.out.println("Child :: show");
	}

	public static void main(String[] args) {
		Super s = new Child();
		s.show();
		
		Child c = new Child();
		c.show();

	}
}
