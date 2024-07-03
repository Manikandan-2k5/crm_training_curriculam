package com.learn.java.intro;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Stack is a Entity in which elements are inserted at the top and removed from the top, i.e Last In First Out Order.</p>
 */
public class Stacks {
	
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>(10);
		stack.push(5);//Pushes the element at the top of the stack. If stack is full, it throws exception.
		stack.push(3);
		stack.push(2);
		stack.push(4);
		stack.push(1);
		System.out.println("Stack after pushing elements: "+stack);
		System.out.println("Popping last element from the stack: "+stack.pop());
		stack.pop();//Removes and returns the top element from the stack. If the stack is empty throws exception.
		stack.pop();
		System.out.println("Stack after popping last three elements from the stack: "+stack);
		System.out.println("Last element fromt he stack: "+stack.peek());//Returns the top element from the stack, if stack is empty returns null.
		System.out.println("Stack is empty: "+stack.isEmpty());//Return true if stack is empty, else returns false.
	}
	
}
