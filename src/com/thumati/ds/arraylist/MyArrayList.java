package com.thumati.ds.arraylist;

public class MyArrayList<T> {
	private Object[] list;
	private int pointer;
	
	public MyArrayList(){
		this.list = new Object[10];
		this.pointer=0;
	}
	
	public MyArrayList(int size){
		this.list = new Object[size];
	}

	public void add(T value) {
		if(pointer==list.length) {
			Object[] newList = new Object[list.length+20];
			System.arraycopy(list, 0, newList, 0, list.length);
			list=newList;
		}
		list[pointer++]=value;
	}
	
	public void remove(Object value) {
		for(int i=0; i<pointer;++i) {
			if(value.equals(list[i])) {
				fastRemove(i);
				return;
			}
		}
	}
	
	private void fastRemove(int index) {
		System.arraycopy(list, index+1, list, index, --pointer);
		list[pointer]=null;
	}
	
	public void removeAt(int index) {
		
	}
	
	public void printList() {
		for(int i=0;i<list.length;++i) {
			System.out.print(i+"."+list[i]+", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add("vasanth");
		list.add("kumar");
		list.add("thumati");
		list.add("deepika");
		list.add("yashitha");
		list.add("malyadri");
		list.add("janu");
		list.add("balaji");
		list.add("sujatha");
		list.add("mahendra");
		list.add("kondaiah");
		list.add("vijay");
		list.add("manohar");

		list.printList();
		
		list.remove("vasanth");
		
		list.printList();
	}

}
