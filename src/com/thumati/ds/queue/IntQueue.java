package com.thumati.ds.queue;

public class IntQueue {
	
	private int[] queue;
	private int size;
	private int total;
	private int front;
	private int rear;
	
	public IntQueue() {
		this.size = 3;
		this.queue = new int[this.size];
		this.front = 0;
		this.rear = 0;
		this.total = 0;
	}
	
	public IntQueue(int size) {
		this.size = size;
		this.queue = new int[this.size];
		this.front = 0;
		this.rear = 0;
		this.total = 0;
	}

	public boolean enqueue(int n) {
		if(!isFull()) {
			++total;
			queue[rear] = n;
			rear = (rear + 1) % size;
			return true;
		}else {
			return false;
		}
	}
	
	public int dequeue() {
		int item=0;
		if(!isEmpty()) {
			--total;
			item = queue[front]; 
			front = (front + 1) % size;
		}
		return item;
	}
	
	public boolean isFull() {
		return (this.total==this.size);
	}
	
	public boolean isEmpty() {
		return (this.total==0);
	}
	
	public void showAll() {
		if(total!=0) {
			System.out.println("Elements in the queue : ");
			for(int i=0; i<total;++i) {
				 System.out.print(queue[front]+",");
				 front = (front + 1) % size;
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		IntQueue queue = new IntQueue();
		
		System.out.println("Enqueue : "+queue.enqueue(12));
		System.out.println("Enqueue : "+queue.enqueue(9));
		System.out.println("Enqueue : "+queue.enqueue(3));
		queue.showAll();
		System.out.println("Enqueue : "+queue.enqueue(2));
		System.out.println("Enqueue : "+queue.enqueue(4));
		
		System.out.println("Dequeue : "+queue.dequeue());
		queue.showAll();
		System.out.println("Dequeue : "+queue.dequeue());
		System.out.println("Dequeue : "+queue.dequeue());
		queue.showAll();
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		System.out.println("Enqueue : "+queue.enqueue(6));
		//System.out.println(queue.dequeue());
		//System.out.println(queue.dequeue());
		
		queue.showAll();

	}

}
