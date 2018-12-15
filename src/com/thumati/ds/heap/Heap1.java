package com.thumati.ds.heap;

public class Heap1 {
	private int maxSize;
	private int currentSize;
	private Node1[] heapArray;

	public Heap1(int size) {
		this.maxSize=size;
		this.currentSize=0;
		this.heapArray=new Node1[maxSize];
	}
	
	public boolean isEmpty() {
		return (currentSize==0);
	}
	
	public boolean isFull() {
		return (maxSize==currentSize);
	}
	
	public boolean insert(int key) {
		if(isFull()) {
			return false;
		}
		Node1 newNode = new Node1(key);
		heapArray[currentSize]=newNode;
		trickleUp(currentSize);
		++currentSize;
		return true;
	}
	
	private void trickleUp(int index) {
		int parentIndex=(index-1)/2;
		Node1 nodeToInsert = heapArray[index];
		
		while(index>0 && heapArray[parentIndex].getKey()<nodeToInsert.getKey()) {
			heapArray[index]=heapArray[parentIndex];
			index=parentIndex;
			parentIndex=(index-1)/2;
		}
		heapArray[index]=nodeToInsert;
	}
	
	public Node1 remove() {
		Node1 top = heapArray[0];
		heapArray[0]=heapArray[--currentSize];
		trickleDown(0);
		return top;
	}
	
	private void trickleDown(int index) {
		int largerChildIndex;
		Node1 nodeToInsert = heapArray[index];
		//will run as long as index is not on the bottom row(at least 1 child)
		while(index<currentSize/2) {
			int leftChildIndex = (2*index+1);
			int rightChildIndex = (2*index+2);
			if(rightChildIndex<currentSize && heapArray[leftChildIndex].getKey()<heapArray[rightChildIndex].getKey()) {
				largerChildIndex=rightChildIndex;
			}else {
				largerChildIndex=leftChildIndex;
			}
			
			if(nodeToInsert.getKey()>=heapArray[largerChildIndex].getKey()) {
				break;
			}
			
			heapArray[index]=heapArray[largerChildIndex];
			index=largerChildIndex;
		}
		heapArray[index]=nodeToInsert;
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
