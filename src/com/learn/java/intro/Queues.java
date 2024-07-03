package com.learn.java.intro;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * <p>Queue is an Entity in which elements are inserted at the last and removed from first, i.e First In First Out Order.</p>
 */
public class Queues {
	
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> queue  = new ArrayBlockingQueue<Integer>(10);
		queue.add(1);//adds element to the stack, throws exception when trying to add element to a queue which is full.
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		queue.add(10);
		System.out.println("Queue after adding elements till its capacity: "+queue);
//		queue.add(11);//Throws Exception for adding elements in the queue which is already full.
		queue.offer(12);//Returns true if adds the element, else returns false in the case of queue is full
		queue.remove();//Removes head from the queue, if the is empty, then it throws exception.
		queue.remove();
		queue.remove();
		System.out.println("Queue after removing 3 elements: "+queue);
		queue.poll();//Removes and retrieves the head from the queue, if queue is empty then it will return null.
		queue.poll();
		queue.poll();
		System.out.println("Queue after polling 3 elements: "+queue);
		System.out.println("Head of the queue: "+queue.element());//Prints the head from the queue, if queue is empty, then it throws exception.
		System.out.println("Head of the queue: "+queue.peek());//Prints the head from the queue, if queue is empty, then it returns null.
		List<Integer> list  = new ArrayList<Integer>();
		queue.drainTo(list);//Removes all the element from the queue and puts it in the given list.
		System.out.println("Queue after draining all the elements to list: "+queue);
		System.out.println("Peeking the head after draining the queue: "+queue.peek());
		//System.out.println("Printing the head after draining the queue using element method: "+queue.element());Throws Exception for accessing head in the queue which is empty.
		System.out.println("List after the elements from queue drained to the list: "+list);
	}
	
}
