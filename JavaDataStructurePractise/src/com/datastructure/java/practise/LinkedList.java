package com.datastructure.java.practise;

/*
 * This class will perform the following major operation.
 * 1.Create LinkedList
 * 2.Insert Node in Linked List
 * 3.Delete Node From Linked List
 * 4.Search the Node in Linked List
 * 5.Delete the Linked List
 */
public class LinkedList
{

	//This is only field of class will hold the head of linked list.	
	private ListNode head;
	private int length=0;	
	
	/*
	 * Return the first node of the list
	 */
	public synchronized ListNode getHead()
	{
		return head;		
	}
	
	/*
	 * Insert a node at beginning of the list.
	 */
	public synchronized void InsertAtBeginning(ListNode node)
	{
		node.setNext(head);
		head=node;
		length++;
	}
	
	/*
	 * Insert a node at end of the list.
	 */
	public synchronized void InsertAtEnd(ListNode node)
	{
		if(head==null)
		{
			head=node;
		}
		else
		{
			ListNode p,q;
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(node);
		}
		length++;
	}
	/*
	 * Add a new value to given position
	 */
	public void insert(int position,int data)
	{
		//fix the position
		if(position<0)
		{
			position=0;
		}
		if(position>length)
		{
			position=length;
		}
		//If the list is empty,make it be the only element.
		if(head==null)
		{
			head=new ListNode(data);			
		}
		//If adding the front of list
		else if(position==0)
		{
			ListNode temp=new ListNode(data);
			temp.setNext(head);
			head=temp;
		}
		//Else find the correct position and insert.
		else
		{
			ListNode temp=head;
			for(int i=1;i<position;i++)
			{
				temp=temp.getNext();
			}
			ListNode node=new ListNode(data);
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		length++;
	}
	
	/*
	 * Remove node from beginning of the list
	 */
	public synchronized ListNode removeBeginningNodeFromList()
	{
		ListNode node=head;
		if(node!=null)
		{
			head=node.getNext();
			node.setNext(null);
			length--;
		}
		return node;
	}
	
	/*
	 * Remove the node from end of list.
	 */
	public synchronized ListNode removeEndNodeFromList()
	{
		if(head==null)
		{
			return null;
		}
		ListNode p=head,q=null,next=head.getNext();
		if(next==null)
		{
			head=null;
			return p;
		}
		while((next=p.getNext())!=null)
		{
			q=p;
			p=next;
		}
		q.setNext(null);
		length--;
		return p;
	}
	
	/*
	 * Remove matched node from linked list
	 */
	
	public synchronized void removeMatchedNodeFromList(ListNode node)
	{
		
		if(head==null)
			return;
		
		if(node.equals(head))
		{
			head=head.getNext();
			return;
		}
		
		ListNode p=head,q=null;
		while((q=p.getNext())!=null)
		{
			if(node.equals(q))
			{
				p.setNext(q.getNext());
				return;
			}
			p=q;
		}
		length--;
	}
	
	/*
	 * Remove the value at given position.
	 */
	public synchronized void remove(int position)
	{
		//Fix position
		if(position < 0)
			position=0;
		
		if(position >= length)
			position=length-1;
		
		//If nothing in list, do nothing
		if(head==null)
			return;
		
		//If removing the head element
		if(position==0)
		{
			head=head.getNext();
		}		
		//else find the element in list and delete
		else
		{
			ListNode temp=head;		
			for(int i=1;i<position;i++)
			{
				temp=temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length--;
	}
	
	/*
	 * Find the position of first value that is equal to given value.
	 */
	public int getPosition(int data)
	{
		ListNode temp=head;
		int pos=0;
		
		while(temp!=null)
		{
			if(temp.getData() == data)
			{
				return pos;
			}
			pos+=1;
			temp=temp.getNext();
		}
		
		return Integer.MIN_VALUE;
	}
	
	/*
	 * Remove everything from the list.
	 */
	public void clearlist()
	{
		head=null;
		length=0;
	}	
	
	/*
	 * Return the current length of linked list
	 */
	public int lengthOfLinkedList()
	{
		return length;
	}

	@Override
	public String toString() {
		
		String result="[";
		
		if(head==null)
		{
			return result+="]";
		}
		result=result+head.getData();
		ListNode temp=head.getNext();
		while(temp!=null)
		{
			result=result+","+temp.getData();
			temp=temp.getNext();
		}
		return result+"]";
	}	
	
}