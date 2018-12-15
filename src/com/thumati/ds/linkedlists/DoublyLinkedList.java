package com.thumati.ds.linkedlists;

public class DoublyLinkedList {

	class Node {
		private Node prev;
		private int data;
		private Node next;
		
		public String toString() {
			return data+"-->"+next;
		}
	}

	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public boolean insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()) {
			tail = newNode;
			head = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		return true;
	}
	
	public boolean insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}

		return true;
	}

	public boolean insertAfter(int key, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()) {
			return false;
		}else {
			for(Node node=head; node!=null; node=node.next) {
				if(node.data == key) {
					if(node!=tail) {
						Node temp = node.next;
						newNode.prev = node;
						newNode.next = temp;
						node.next = newNode;
						temp.prev = newNode;
						break;
					}else {
						node.next = newNode;
						newNode.prev = node;
						tail = newNode;
					}
				}
			}
			return true;
		}
	}
	
	public boolean deleteFirst() {
		if(isEmpty()) {
			System.out.println("List is Empty.........................");
			return false;
		}else {
			Node temp = head;
			head = head.next;
			temp.next = null;
			head.prev = null;
			return true;
		}
	}

	public boolean deleteLast() {
		if(isEmpty()) {
			System.out.println("List is Empty.........................");
			return false;
		}else {
			Node temp = tail;
			tail = tail.prev;
			temp.prev = null;
			tail.next = null;
			return true;			
		}
	}
	
	public boolean deleteNode(int key) {
		if(isEmpty()) {
			System.out.println("List is Empty.........................");
			return false;
		}else {
			Node node = findNode(key);
			if(node==head) {
				head = node.next;
				node.next = null;
				head.prev = null;
			}else if(node==tail){
				tail = node.prev;
				node.prev=null;
				tail.next=null;
			}else {
				Node prevNode = node.prev;
				Node nextNode = node.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
			}
			return true;			
		}
	}

	public Node findNode(int key) {
		Node node = head;
		while(node!=null) {
			if(node.data==key) {
				break;
			}
			node = node.next;
		}
		return node;
	}
	
	public void dispalyList() {
		if(!isEmpty()) {
			System.out.println();
			for(Node node = head; node!=null; node = node.next) {
				System.out.print(node.data+"-->");
			}
		}else {
			System.out.println("List is Empty.........................");
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insertFirst(1);
		dl.insertFirst(2);
		dl.insertFirst(3);
		
		dl.dispalyList();
		
		dl.insertLast(4);
		dl.insertLast(5);
		dl.insertLast(6);
		
		dl.dispalyList();
		
		dl.deleteFirst();
		
		dl.dispalyList();

		dl.deleteLast();
		
		dl.dispalyList();

		dl.insertAfter(1, 3);
		
		dl.dispalyList();
		
		dl.insertAfter(5, 6);
		
		dl.dispalyList();
		
		dl.deleteNode(2);
		
		dl.dispalyList();
		
		dl.deleteNode(6);
		
		dl.dispalyList();
	}

}
