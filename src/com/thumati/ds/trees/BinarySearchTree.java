package com.thumati.ds.trees;

import java.util.Stack;

public class BinarySearchTree {
	private Node root;
	
	public void insert(int key, String value) {
		Node newNode = new Node(key, value);
		if(root==null) {
			root = newNode;
			return;
		}else {
			Node current=root;
			Node parent;
			while(true) {
				parent = current;
				if(key<=current.key) {
					current = current.leftNode;
					if(current==null) {
						parent.leftNode=newNode;
						return;
					}
				}else {
					current = current.rightNode;
					if(current==null) {
						parent.rightNode=newNode;
						return;
					}
				}
			}
		}
	}
	
	public Node findMin() {
		Node current = root;
		Node last=null;
		while(current!=null) {
			last = current;
			current=current.leftNode;
		}
		return last;
	}
	
	public Node findMax() {
		Node current = root;
		Node last=null;
		while(current!=null) {
			last = current;
			current=current.rightNode;
		}
		return last;
	}
	
	/**
	 * 1.Find the node to delete
	 * 2.Node to delete is a leaf node.
	 * 		a.If Node to delete is a root node.
	 * 		b.If Node to delete is a left node.
	 * 		c.If Node to delete is a right node. 
	 * 3.Node to delte has only one child.
	 * 		a.If Node to delte has left child.
	 * 			I.If node to delete is a root.
	 * 			II.If Node to delete is a left node.
	 * 			III.If Node to delete is a right node.
	 * 		b.If Node to delte has right child.
	 * 			I.If node to delete is a root.
	 * 			II.If Node to delete is a left node.
	 * 			III.If Node to delete is a right node.
	 * 4.Node to delte has two children(left and right).
	 * 		a.
	 */
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		
		boolean isLeftNode=false;
		
		//searching for the node to delete. if not found then return false;
		while(current.key!=key) {
			parent = current;
			if(key<current.key) {
				current = current.leftNode;
				isLeftNode = true;
			}else {
				current = current.rightNode;
				isLeftNode = false;
			}
			if(current==null) {
				return false;
			}
		}
		
		//Found the node to delete
		Node nodeToDelete = current;
		
		//If the node to delete is a leaf node.(no children)
		if(nodeToDelete.leftNode==null && nodeToDelete.rightNode==null) {
			if(nodeToDelete==root) {//If the node to delete is a root node and leaf node
				root=null;
			}else if(isLeftNode) {//If the node to delete is a left node and leaf node
				parent.leftNode=null;
			}else {//If the node to delete is a right node and leaf node
				parent.rightNode=null;
			}
		}else if(nodeToDelete.rightNode==null) {//If the node to delete has only one child and it's child is left node.
			if(nodeToDelete==root) {//If the node to delete is a root node and it has only one child and it's child is left node.
				root = nodeToDelete.leftNode;
			}else if(isLeftNode) {//If the node to delete is a left node and it has only one child and it's child is left node.
				parent.leftNode=nodeToDelete.leftNode;
			}else{//If the node to delete is a right node and it has only one child and it's child is left node.
				parent.rightNode=nodeToDelete.leftNode;
			}
		}else if(nodeToDelete.leftNode==null) {//If the node to delete has only one child and it's child is right node.
			if(nodeToDelete==root) {//If the node to delete is a root node and it has only one child and it's child is right node.
				root = nodeToDelete.rightNode;
			}else if(isLeftNode) {//If the node to delete is a left node and it has only one child and it's child is right node.
				parent.leftNode=nodeToDelete.rightNode;
			}else{//If the node to delete is a right node and it has only one child and it's child is right node.
				parent.rightNode=nodeToDelete.rightNode;
			}
		}else {//If the node to delete has two children
			Node successor = getSuccessor(nodeToDelete);
			
			//connect parent of nodeToDelete to successor
			if(nodeToDelete==root) {//if the node to delete is itself root node.
				root = successor;
			}else if(isLeftNode){
				parent.leftNode=successor;
			}else {
				parent.rightNode=successor;
			}
			successor.leftNode=nodeToDelete.leftNode;
		}
		return true;
	}
	
	private Node getSuccessor(Node nodeToDelete) {
		Node successorparent = nodeToDelete;
		Node successor = nodeToDelete;
		
		//Go to the one level right child.
		Node current = nodeToDelete.rightNode;
		
		//Start going left down the tree until node has no left child. 
		while(current!=null) {
			successorparent = successor;
			successor = current;
			current=current.leftNode;
		}
		
		//If successor not a immediate right child of nodeToDelete 
		if(successor!=nodeToDelete.rightNode) {
			successorparent.leftNode=successor.rightNode;
			successor.rightNode=nodeToDelete.rightNode;
		}
		return successor;
	}
	
	public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        
        while(isRowEmpty==false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(" ");
            }
                
            while(globalStack.isEmpty()==false) {
                Node temp = (Node)globalStack.pop(); 
                if(temp != null) {
                    System.out.print(temp.key); 
                    localStack.push(temp.leftNode); 
                    localStack.push(temp.rightNode);
                    if(temp.leftNode != null || temp.rightNode != null) {
                        isRowEmpty = false; 
                    }
                } else {
                    System.out.print("--"); 
                    localStack.push(null); 
                    localStack.push(null);
                }
                
                for(int j=0; j<nBlanks*2-2; j++) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            nBlanks = nBlanks/2;
            
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() ); 
            }
        System.out.println( "......................................................");
 
 }

}
