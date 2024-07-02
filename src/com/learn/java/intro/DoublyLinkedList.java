package com.learn.java.intro;

public class DoublyLinkedList <E>{
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.delete(1);
		linkedList.delete(Integer.valueOf(4));
		linkedList.update(5,2);
		linkedList.add(5);
		linkedList.add(4, 4);
		System.out.println("Linked List: "+linkedList);
		System.out.println("Head: "+linkedList.head.element);
		System.out.println("Tail: "+linkedList.tail.element);
	}
	
	class Node{
		E element;
		Node prev;
		Node next;
		
		public Node(E element, Node prev, Node next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node head;
	private Node tail;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean add(E element) {
		Node current = head;
		if(current==null) {
			head = new Node(element, null, null);
			tail = head;
		}
		else if(current.next==null) {
			head.next = new Node(element, head, null);
			tail = head.next;
		}
		else {
			while(current.next!=null) {
				current = current.next;
			}
			current.next = new Node(element, current, null);
			tail = current.next;
		}
		return true;
	}
	
	public boolean add(int index, E element) {
		if(index==0) {
			Node node = new Node(element, null, head);
			head = node;
			return true;
		}
		if(head==null) {
			return false;
		}
		Node current = head;
		int count = 0;
		while(current!=null && count!=index) {
			current = current.next;
			count++;
		}
		if(index!=count) {
			return false;
		}
		if(current==null) {
			tail.next = new Node(element, tail, null);
			tail = tail.next;
			return true;
		}
		current.prev.next = new Node(element, current.prev, current);
		return true;
	}
	
	public boolean delete(E element) {
		Node current = head;
		if(current==null) {
			return false;
		}
		else if(current.element==element){
			head = head.next;
			return true;
		}
		else {
			while(current!=null) {
				if(current.element==element) {
					if(current.next==null) {
						tail = current.prev;
					}
					current.prev.next = current.next;
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}
	
	public boolean delete(int index) {
		if(head==null) {
			return false;
		}
		else if(index==0){
			head = head.next;
			return true;
		}
		else {
			Node current = head;
			int count = 0;
			while(current!=null && count!=index) {
				current = current.next;
				count++;
			}
			if(count!=index || current==null) {
				return false;
			}
			if(current.next==null) {
				tail.prev.next = null;
				tail = tail.prev;
				return true;
			}
			current.next.prev = current.prev;
			current.prev.next = current.next;
			return true;
		}
}
	
	public boolean update(E element1, E element2) {
		Node current = head;
		while(current!=null) {
			if(current.element==element1) {
				current.element=element2;
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String string = "";
		if(head==null) {
			string+="LinkedList is empty.";
			return string;
		}
		Node current = head;
		string+="[";
		while(current!=null) {
			if(current.next==null) {
				string+=current.element+"]\n";
				current = current.next;
				continue;
			}
			string+=current.element+",";
			current = current.next;
		}
		return string;
	}
}
