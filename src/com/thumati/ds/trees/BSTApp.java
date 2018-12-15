package com.thumati.ds.trees;

import java.util.HashMap;
import java.util.Hashtable;

public class BSTApp {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10, "ten");
		tree.insert(20, "twenty");
		tree.insert(15, "fifteen");
		tree.insert(34, "thirty four");
		
		tree.displayTree();
		
		/*HashMap<String, String> map = new HashMap<String, String>();
		map.put("king", "akshay");
		map.put(null, "kumar");
		map.put(null, "reddy");
		
		System.out.println(map);
		
		Hashtable ht = new Hashtable();
		ht.put(null, "kumar");
		
		System.out.println("king".hashCode());
		System.out.println("gnik".hashCode());*/
		
		System.out.println("Min : "+tree.findMin().key);
		System.out.println("Max : "+tree.findMax().key);
		
		System.out.println("Delete : "+tree.delete(10));
		tree.displayTree();
		System.out.println("Delete : "+tree.delete(34));
		tree.displayTree();
		
		System.out.println("Min : "+tree.findMin().key);
		System.out.println("Max : "+tree.findMax().key);

	}

}
