package com.learn.java.intro;


/**
 * <p>This class is the Implementation of Singly Linked List.</p>
 * @param <E> E can be any Object which can be stored as element E in the nodes.
 */
public class LinkedList<E> {
	
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(7);
		linkedList.add(8);
		linkedList.add(9);
		linkedList.add(10);
		linkedList.update(10, 2);
		linkedList.delete(4);
		linkedList.printAllNodes();
		System.out.println("\nHead: "+linkedList.head.element);
		System.out.println("Tail: "+linkedList.tail.element);
	}
	
	/**
	 * <p>This is a Node class which when chained forms a Singly Linked List. It stores data of any Reference Type.</p>
	 */
	class Node{
		E element;
		Node next;
		
		public Node(E element, Node next) {
			this.element = element;
			this.next = next;
		}
	}
	
	/**
	 * <p>Constructor for the Linked List which initialises head and tail node to null</p>
	 */
	public LinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	private Node head;
	private Node tail;
	
	/**
	 * <p>Appends a Node containing element to the end of the Linked List.</p>
	 * @param element Element to be stored in the Node and appended to the Linked List.
	 */
	public void add(E element) {
		Node node = new Node(element, null);
		if(head==null) {
			head = node;
			tail = head;
		}
		else {
			Node current = head;
			while(current.next!=null) {
				current = current.next;
			}
			current.next = node;
			tail = current.next;
		}
	}
	
	/**
	 * <p>Deletes a Node from the Linked List which contains the element given in the argument.</p>
	 * @param element Node containing the element will be deleted from the Linked List.
	 * @return Returns true if the Node containing the element is deleted, else returns false.
	 */
	public boolean delete(E element) {
		Node current = head;
		Node prev = null;
		Node next = null;
		while(current!=null) {
			if(current.element==element) {
				if(prev==null) {
					head=head.next;
					return true;
				}
				prev.next = next;
				if(next==null) {
					tail = prev;
				}
				return true;
			}
			prev = current;
			current = current.next;
			next = current.next;
		}
		return false;
	}
	
	/**
	 * <p>Updates the element value of the node to element2 which contains the element value as element1.</p>
	 * @param element1 element to be replaced by the element2 in the Node which contains element value as element1 in the Linked List.
	 * @param element2 element to be replaced in the element value of the Node which contains element value as element1 in the Linked List.
	 * @return Returns true if the element value of the node that containing the element value as element1 is updated to element2, else returns false.
	 */
	public boolean update(E element1, E element2) {
		Node current = head;
		while(current!=null) {
			if(current.element==element1) {
				current.element = element2;
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	
	/**
	 * <p>Prints all the elements of the Nodes in the Linked List.</p>
	 */
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
