package com.thumati.ds.heap;

public class HeapApplication {

	public static void main(String[] args) {
		//System.out.println(-5/2);
		//System.out.println(-1/2);
		
		MaxHeap heap = new MaxHeap(10);
		heap.insert(10);
		heap.insert(12);
		heap.insert(42);
		heap.insert(35);
		heap.insert(16);
		heap.insert(88);
		heap.insert(42);
		heap.insert(7);
		//heap.displayHeap();
		heap.remove();
		heap.displayHeap();
	}
}
