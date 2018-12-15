package com.thumati.ds.lognacademy;

public class CircularLinkedList {
	private Node marker;
	private Node previous;
	private Node head;
	int size=0;
	
	private boolean isEmpty() {
		return (marker==null);
	}
	
	public void insert(Object data) {
		if(isEmpty()) {
			marker=new Node(data, null);
			head=marker;
			marker.setNext(marker);
		}else {
			Node node = new Node(data, head);
			marker.setNext(node);
			marker = node;
		}
		++size;
	}
	
	public Object delete() {
		if(isEmpty()) {
			return null;
		}else {
			Object temp = marker.getData();
			previous.setNext(marker.getNext());
			marker = marker.getNext();
			--size;
			return temp;
		}
	}
	
	public Object head() {
		if (isEmpty())
			return null;
		else
			return marker.getNext().getData();
	}
	
	public void move() {
		if (marker != null) {
			previous = marker;
			marker = marker.getNext();
		}
	}
	
	public String toString() {
		String result;
		if(isEmpty()) {
			result = "Empty Result";
		}else {
			Node head = marker.getNext();
			marker.setNext(null);
			result = head.toString();
			marker.setNext(head);
		}
		return result;
	}
	
	public void setMarkerPosition(Object data) {
		 if (marker.getData().toString().equals(data.toString()))
             return;
         else {
             while (!marker.getData().toString().equals(data.toString())) {
                 marker = marker.getNext();
             }
         }
	}
	
	 public int size() {
         return size;
     }
}
