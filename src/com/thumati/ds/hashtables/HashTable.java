package com.thumati.ds.hashtables;

public class HashTable {
	private String[] hashArray;
	private int arraySize;
	private int size;
	
	public HashTable(int noOfSlots) {
		if(isPrime(noOfSlots)) {
			hashArray = new String[noOfSlots];
			arraySize=noOfSlots;
		}else {
			int primeCount = getNextPrime(noOfSlots);
			hashArray = new String[primeCount];
			arraySize=primeCount;
			System.out.println("Hashtable size is given "+noOfSlots+" is not a prime");
			System.out.println("Hashtable size changed to "+primeCount);
		}
	}

	private boolean isPrime(int n) {
		for(int i=2; i*i<=n; ++i) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	private int getNextPrime(int n) {
		for(int i=n; true; ++i) {
			if(isPrime(i)) {
				return i;
			}
		}
	}
	
	//returns preferred index position
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal=hashVal%arraySize;
		if(hashVal<0) {
			hashVal+=arraySize;
		}
		return hashVal;//ideal index position we'd like to insert or search in
	}
	
	//return step size greater than zero
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal%=arraySize;
		if(hashVal<0) {
			hashVal+=arraySize;
		}
		return 3-hashVal%3;
	}
	
	public void insert(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);
		while(hashArray[hashVal]!=null) {
			hashVal+=stepSize;
			hashVal%=arraySize;
		}
		hashArray[hashVal]=word;
		System.out.println("Inserted word: "+word);
		size++;
	}
	
	public String find(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);
		while(hashArray[hashVal]!=null) {
			if(word.equals(hashArray[hashVal])) {
				return hashArray[hashVal];
			}
			hashVal+=stepSize;
			hashVal%=arraySize;
		}
		return hashArray[hashVal];
	}

	public void displayTable() {
		System.out.println("table:");
		for(int i=0;i<arraySize;++i) {
			if(hashArray[i]!=null) {
				System.out.println(hashArray[i]+" ");
			}else {
				System.out.println("** ");
			}
		}
	}
	
	public static void main(String[] args) {
		HashTable table = new HashTable(19);
		
		table.insert("Apple");
		table.insert("Hello");
		table.insert("Feeling");
		table.insert("Water");
		table.insert("Africa");
		table.insert("Speed");
		table.insert("Phone");
		table.insert("September");
		table.insert("Michael");
		table.insert("Milk");
		table.insert("Huge");
		table.insert("Dogs");
		
		table.displayTable();
		
		System.out.println("===========FIND ELEMENTS=============");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Zebra"));
		System.out.println(table.find("Feeling"));
		System.out.println(table.find("Water"));
		System.out.println(table.find("Africa"));
		System.out.println(table.find("Feeling"));
	}
}
