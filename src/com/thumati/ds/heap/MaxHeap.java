package com.thumati.ds.heap;

public class MaxHeap { 
	private Node[] heapArray;
	private int maxSize;//size of the array
	private int currentSize;//no of nodes in the array
	
	public MaxHeap(int size) {
		this.maxSize=size;
		this.heapArray = new Node[size];
		this.currentSize=0;
	}
	
	public int getSize() {
		return currentSize;
	}
	
	public boolean isEmpty() {
		return currentSize==0;
	}
	
	public boolean isFull() {
		return (currentSize==maxSize);
	}
	
	public boolean insert(int key) {
		if(isFull()) {
			return false;
		}
		
		Node newNode = new Node(key);
		
		heapArray[currentSize]=newNode;
		
		trickleUp(currentSize);
		
		++currentSize;
		
		return true;
	}
	
	private void trickleUp(int index) {
		int parentIndex = (index-1)/2;
		Node nodeToInsert = heapArray[index];
		while(index>0 && heapArray[parentIndex].getKey()<nodeToInsert.getKey()) {
			heapArray[index] = heapArray[parentIndex];
			index = parentIndex;
			parentIndex = (index-1)/2;
		}
		heapArray[index] = nodeToInsert;
	}

	public Node remove() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		heapArray[currentSize]=null;
		System.out.println("=========================================================");
		for(int index=0; index<heapArray.length;++index) {
			if(heapArray[index]!=null) {
				System.out.print(heapArray[index].getKey()+", ");
			}else {
				System.out.println();
				break;
			}
		}
		System.out.println("=========================================================");
		return root;
	}

	private void trickleDown(int index) {
		int largerChildIndex;
		Node top = heapArray[index];//save last into top varaible
		
		//will run as long as index is not on the bottom row(at least 1 child)
		while(index<currentSize/2) {
			int leftChildINdex = 2*index+1;
			int rightChildINdex = 2*index+2;
			//int rightChildINdex = leftChildINdex+1;
			
			//figure out which child is larger
			if(rightChildINdex<currentSize && heapArray[leftChildINdex].getKey()<heapArray[rightChildINdex].getKey()) {
				largerChildIndex = rightChildINdex;
			}else {
				largerChildIndex = rightChildINdex;
			}
			
			if(top.getKey()>=heapArray[largerChildIndex].getKey()) {
				//successfully made root the largest key
				break;
			}
			
			heapArray[index]=heapArray[largerChildIndex];
			index=largerChildIndex;//go down
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
