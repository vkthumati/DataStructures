package com.thumati.ds.trees;

public class MyBinarySearchTreeApplication {

    private Node root;

    public void insert(int key, String value){
        Node newNode = new Node(key, value);
        if(root==null){
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;
        while(true){
            parent = current;
            if(key<=current.key){
                current = current.leftNode;
                if(current==null){
                    parent.leftNode = newNode;
                    return;
                }
            }else{
                current = current.rightNode;
                if(current==null){
                    parent.rightNode = newNode;
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
