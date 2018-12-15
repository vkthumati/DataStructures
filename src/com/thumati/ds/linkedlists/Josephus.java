package com.thumati.ds.linkedlists;

public class Josephus {
	private Node head;
	private Node tail;
	
	private class Node{
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			head=newNode;
			tail=newNode;
		}else {
			tail.setNext(newNode);
			tail=newNode;
			tail.setNext(head);
		}
	}
	
	private boolean isEmpty() {
		return (head==null);
	}
	
	public void print() {
		Node current = head;
		System.out.println();
		while(current!=null) {
			System.out.print(current.getData()+"-->");
			current=current.getNext();
			if(current==head) {
				break;
			}
		}
	}
	
	public void josePhusProblem() {
		int hops=3;
		Node current = head;
		Node previous;
		while(true) {
			int i=0;
			while(i++<hops) {
				previous=current;
				current=current.getNext();
				if(i==hops) {
					if(current==head) {
						head = current.next;
					}else if(current==tail){
						tail = previous;	
					}
					previous.setNext(current.getNext());
					current.setNext(null);
					current = previous.getNext();
					print();
					break;
				}
			}
			if(head==tail) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Josephus josephus = new Josephus();
		josephus.insert(1);
		josephus.insert(2);
		josephus.insert(3);
		josephus.insert(4);
		josephus.insert(5);
		josephus.insert(6);
		josephus.insert(7);
		josephus.insert(8);
		josephus.insert(9);
		josephus.insert(10);
		josephus.insert(11);
		josephus.insert(12);
		josephus.insert(13);
		josephus.print();
		
		josephus.josePhusProblem();
	}

}
