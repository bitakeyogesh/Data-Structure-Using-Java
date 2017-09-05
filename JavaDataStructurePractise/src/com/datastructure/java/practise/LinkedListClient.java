package com.datastructure.java.practise;

public class LinkedListClient {

	public static void main(String[] args) {

		LinkedList linkList=new LinkedList();
		linkList.InsertAtBeginning(new ListNode(10));
		linkList.InsertAtEnd(new ListNode(20));
		linkList.InsertAtEnd(new ListNode(30));
		linkList.InsertAtEnd(new ListNode(40));
		linkList.insert(1, 5);
		System.out.println("LinkedList Before Delete Operations="+linkList);
		linkList.removeBeginningNodeFromList();
		linkList.removeEndNodeFromList();				
		System.out.println("LinkedList After Delete Operations="+linkList);
		System.out.println("Length="+linkList.lengthOfLinkedList());
		linkList.clearlist();
		System.out.println("LinkedList After clear="+linkList);
		
	}
}