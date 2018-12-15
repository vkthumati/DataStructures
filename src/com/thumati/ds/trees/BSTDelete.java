package com.thumati.ds.trees;

public class BSTDelete {
	Node root;
	
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
		Node currentNode = root;
		Node parentNode = root;
		boolean isLeftNode=false;
		
		//searching the node to delete with the key
		while(currentNode.key!=key) {
			parentNode = currentNode;
			if(key<currentNode.key) {
				currentNode = currentNode.leftNode;
				isLeftNode=true;
			}else {
				currentNode = currentNode.rightNode;
				isLeftNode=false;
			}
			if(currentNode==null) {
				return false;
			}
		}
		
		//found the node to delete
		Node nodeToDelete = currentNode;
		
		//If nodeToDelete is a leaf node(no children)
		if(nodeToDelete.leftNode==null && nodeToDelete.rightNode==null) {
			if(nodeToDelete==root) {//If the nodeToDelete is the root node
				root=null;
			}else if(isLeftNode) {//If the nodeToDelete is the left node
				parentNode.leftNode=null;
			}else {//If the nodeToDelete is the right node
				parentNode.rightNode=null;
			}
		}else if(nodeToDelete.rightNode==null) {//If nodeToDelete has only one child that is left child
			if(nodeToDelete==root) {
				root = nodeToDelete.leftNode;
			}else {
				if(isLeftNode) {//If the nodeToDelete is the left node
					parentNode.leftNode=nodeToDelete.leftNode;
				}else {//If the nodeToDelete is the right node
					parentNode.rightNode=nodeToDelete.leftNode;
				}
			}
		}else if(nodeToDelete.leftNode==null) {//If nodeToDelete has only one child that is right child
			if(nodeToDelete==root) {//If the nodeToDelete is the root node
				root = nodeToDelete.rightNode;
			}else {
				if(isLeftNode) {//If the nodeToDelete is the left node
					parentNode.leftNode=nodeToDelete.rightNode;
				}else {//If the nodeToDelete is the right node
					parentNode.rightNode=nodeToDelete.rightNode;
				}
			}
		}else {//If the node to delete has two children
			Node successor = getSuccessor(nodeToDelete);
			
			//connect parent of nodeToDelete to successor
			if(nodeToDelete==root) {//if the node to delete is itself root node.
				root = successor;
			}else if(isLeftNode){
				parentNode.leftNode=successor;
			}else {
				parentNode.rightNode=successor;
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
}
