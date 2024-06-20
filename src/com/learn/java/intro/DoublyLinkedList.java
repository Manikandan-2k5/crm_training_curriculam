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
		linkedList.delete(2);
		linkedList.update(5,2);
		linkedList.printAllNodes();
		System.out.println("\nHead: "+linkedList.head.element);
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
	
	public void add(E element) {
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
	
	public void printAllNodes() {
		if(head==null) {
			System.out.println("LinkedList is empty.");
			return;
		}
		System.out.print("LinkedList: ");
		Node current = head;
		System.out.print("[");
		while(current!=null) {
			if(current.next==null) {
				System.out.println(current.element+"]");
				current = current.next;
				continue;
			}
			System.out.print(current.element+",");
			current = current.next;
		}
	}
}
