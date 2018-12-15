package com.thumati.ds.heap;

public class MinHeap {
	private int maxSize;
	private int currentSize;
	private Node[] heapArray;
	
	public MinHeap(int size) {
		this.maxSize=size;
		this.currentSize=0;
		this.heapArray=new Node[maxSize];
	}
	
	public boolean isFull() {
		return (currentSize==maxSize);
	}
	
	public boolean isEmpty() {
		return (currentSize==0);
	}
	
	public boolean insert(int key) {
		if(isFull()) {
			return false;
		}
		heapArray[currentSize]=new Node(key);
		trickleUp(currentSize);
		++currentSize;
		return true;
	}
	
	public void trickleUp(int index) {
		Node nodeToInsert=heapArray[index];
		int parentIndex=(index-1)/2;
		while(index>0 && heapArray[parentIndex].getKey()>nodeToInsert.getKey()) {
			heapArray[index]=heapArray[parentIndex];
			index = parentIndex;
			parentIndex=(index-1)/2;
		}
		heapArray[index]=nodeToInsert;
	}
	
	public Node remove() {
		Node top = heapArray[0];
		heapArray[0]=heapArray[--currentSize];
		trickleDown(0);
		return top;
	}
	
	public void trickleDown(int index) {
		Node top = heapArray[index];
		int leftChildIndex;
		int rightChildIndex;
		int smallerChildIndex;
		while(index<currentSize/2) {
			leftChildIndex = 2*index+1;
			rightChildIndex = 2*index+2;
			if(heapArray[leftChildIndex].getKey()<heapArray[rightChildIndex].getKey()) {
				smallerChildIndex=leftChildIndex;
			}else {
				smallerChildIndex=rightChildIndex;
			}
			
			if(top.getKey()<=heapArray[smallerChildIndex].getKey()) {
				break;
			}
			
			heapArray[index]=heapArray[smallerChildIndex];
			index=smallerChildIndex;
		}
		heapArray[index]=top;
	}
	
	public void displayHeap() {
        System.out.println("Heap Array: ");
        for(int m = 0; m < currentSize; m++) {
            if(heapArray[m] != null) {
                System.out.print( heapArray[m].getKey() + " ");
            }
            System.out.println();
            
            int nBlanks = 32;
            int itemsPerRow = 1;
            int column = 0;
            int j = 0; // current item
            
            String dots = "...............................";
            System.out.println(dots+dots);
            while(currentSize > 0) {
                if(column == 0) {
                    for(int k = 0; k < nBlanks; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getKey());
                j++;
                if(j == currentSize) {
                    break;
                }
                
                column++;
                // end of row
                if(column == itemsPerRow) {
                    nBlanks = nBlanks/2; // half the blanks
                    itemsPerRow = itemsPerRow * 2;     // twice the items
                    column = 0;
                    System.out.println();
                } else {
                    for(int k=0; k<nBlanks*2; k++) {
                        System.out.print(" ");
                    }
                }
                    
            }
            System.out.println("\n"+dots+dots);
        }
    }
}
