package com.thumati.ds.linkedlists;



public class SingleLinkedList {
	private Node head;
	
	class Node{
		private int value;
		private Node link;
		
		public String toString() {
			return value+" - "+link;
		}
	}
	
	public SingleLinkedList() {
		head = new Node();
	}

	public boolean add(int value) {
		Node node = new Node();
		node.value = value;
		node.link=head.link;
		head.link = node;
		return true;
	}
	
	public void printList() {
		Node node = head;
		System.out.println("\n");
		while(node!=null) {
			System.out.print(node.value+" -> ");
			node = node.link;
		}
		System.out.println("\n");
	}
	
	public boolean delete(int value) {
		if(head.value==value) {
			head = head.link;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.add(2);
		singleLinkedList.add(3);
		singleLinkedList.add(4);
		
		System.out.println(singleLinkedList.head);
		
		singleLinkedList.printList();
	}

}
