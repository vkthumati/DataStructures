package com.thumati.ds.linkedlists;

public class CircularSinglyLinkedList {
	class Node{
		private int data;
		private Node next;
	}

	private Node head;
	private Node tail;

	public CircularSinglyLinkedList() {
		head= null;
		tail = null;
	}

	public boolean insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()) {
			tail = newNode;
		}
		newNode.next = head;
		head = newNode;
		return true;
	}
	
	public boolean insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		tail.next = newNode;
		tail = newNode; 
		return true;
	}
	
	public boolean isEmpty() {
		return (head==null);
	}
	
	public boolean deleteFirst() {
		if(!isEmpty()) {
			Node node = head;
			head = head.next;
			node.next = null;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteLast() {
		if(!isEmpty()) {
			Node temp =head, node = head;
			while(node!=null && node.next!=null) {
				temp = node;
				node = node.next;
			}
			temp.next = null;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int data) {
		return true;
	}
	
	public void showAll() {
		for(Node node = head; node!=null; node=node.next) {
			System.out.print(node.data+"-->");
		}
	}
	
	public static void main(String[] args) {
		CircularSinglyLinkedList cl = new CircularSinglyLinkedList();
		cl.showAll();
		
		cl.insertLast(8);
		cl.insertLast(9);
		
		cl.showAll();
		
		cl.insertFirst(1);
		cl.insertFirst(2);
		System.out.println("\n");
		cl.showAll();
		
		cl.deleteLast();
		System.out.println("\n");
		cl.showAll();

		cl.deleteFirst();
		System.out.println("\n");
		cl.showAll();

		cl.deleteLast();
		System.out.println("\n");
		cl.showAll();

		cl.deleteFirst();
		System.out.println("\n");
		cl.showAll();

		System.out.println("\n");
		cl.showAll();
	}

}
