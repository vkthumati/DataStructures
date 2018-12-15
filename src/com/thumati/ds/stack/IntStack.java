package com.thumati.ds.stack;

public class IntStack {
	
	private int[] stack;
	private int top;
	private int size;
	
	public IntStack() {
		this.top = -1;
		this.size = 5;
		stack = new int[this.size];		
	}
	
	public IntStack(int size) {
		this.top = -1;
		this.size = size;
		this.stack = new int[this.size];
	}

	
	public int push(int n) {
		if(++top<size) {
			stack[top] = n;
		}else {
			this.size = size+5;
			int[] newStack = new int[size];
			for(int i=0; i<stack.length;++i) {
				newStack[i] = stack[i];
			}
			stack = newStack;
			stack[top] = n;
		}
		return n;
	}
	
	public int pop() {
		int n=0;
		if(--top > -1) {
			n = stack[top];
		}
		return n;
	}
	
	@Override
	public String toString() {
		String str="[";
		for(int i=0; i<stack.length;++i) {
			str+= stack[i]+",";
		}
		
		return str+"]";
	}
	
	public static void main(String[] args) {
		IntStack stack = new IntStack();
		for(int i =1; i<=15; ++i) {
			stack.push(i);
		}
		System.out.println(stack);
	}

}
