package com.thumati.ds.stacks.infixpostfixprefix;

public class MyDoubleLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public void insert(T data) {
		Node<T> node = new Node<T>(data);
		if(isEmpty()) {
			head=node;
			tail=node;
		}else {
			tail.next = node;
			node.prev = tail;
			tail=node;
		}
	}
	
	public T remove() {
		if(!isEmpty()) {
			T data = tail.data;
			tail = tail.prev;
			tail.next=null;
			return data;
		}
		return null;
	}
	
	public T peek() {
		return !isEmpty()?tail.data:null;
	}
	
	public boolean isEmpty() {
		return (head==null);
	}
}
