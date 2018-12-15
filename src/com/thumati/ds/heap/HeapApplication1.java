package com.thumati.ds.heap;

public class HeapApplication1 {
	
	public static void main(String[] args) {
		Heap1 heap = new Heap1(10);
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
