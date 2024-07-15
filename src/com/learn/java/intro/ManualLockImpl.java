package com.learn.java.intro;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * <p>Manual Lock Implementation using Producer, Consumer, Items Scenario.</p>
 */
public class ManualLockImpl {
	
	public static void main(String[] args) {
		Items items = new Items();
		
		Thread producer = new Thread(new Producer(items));
		Thread consumer = new Thread(new Consumer(items));
		
		producer.start();
		consumer.start();
		
	}
	
}


/**
 * <p>Items class which have functionalities like add item and get item from an ArrayDeque</p>
 */
class Items{
	
	static Deque<Item> items = new ArrayDeque<Item>();
	String name;
	int price;
	volatile boolean getLock = false;
	volatile boolean putLock = true;
	volatile static int capacity = 5;
	volatile static int length = 0;
	
	/**
	 * <p>This method gets an Item from the Items Stack. If the Items Stack is empty then it waits for the Producer to add Item in the Items Stack.</p>
	 */
	public synchronized void getItem() {
		synchronized (this) {
			while(!getLock) {
				try {
					wait();
				} 
				catch (InterruptedException e) {
					System.out.println("Thread Interrupted.");
				}
			}
			length--;
			putLock = true;
			if(length==0) {
				getLock = false;
			}
			notify();
			System.out.println("Consumer got: "+items.pop().name);
		}
	}
	
	/**
	 * <p>This method put's an Item in the Items Stack. If the Items Stack reached the capacity, then it waits for the Consumer to get an Item from the Items Stack in order to free the space in the Stack.</p>
	 */ 
	public synchronized void addItem(Item item) {
		synchronized (this) {
			while(!putLock) {
				try {
					wait();
				} 
				catch (InterruptedException e) {
					System.out.println("Thread Interrupted.");
				}
			}
			items.addFirst(item);
			length++;
			getLock = true;
			System.out.println("Producer put: "+item.name);
			if(length>=capacity) {
				putLock = false;
			}
			notify();
		}
	}
	
	
}

/**
 * <p>Consumer class implementing Runnable to treat Consumer as thread. It gets an item from the Item stack in the Items class.</p>
 */
class Consumer implements Runnable{
	
	Items items;
	
	public Consumer(Items items) {
		this.items = items;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			items.getItem();
		}
	}
	
}

/**
 * <p>Producer class implementing Runnable to treat is as a Thread. It adds item to the Items Stack in the Items Class</p>
 */
class Producer implements Runnable{ 
	
	Items items;
	
	public Producer(Items items) {
		this.items = items;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(500);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			items.addItem(new Item("Umbrella", 500));
		}
	}
	
}

/**
 * <p>Item class which represents an Item entity and stored in the Items Stack in the Items class.</p>
 */
class Item {
	String name;
	int price;
	
	public Item(String name, int price){
		this.name = name;
		this.price = price;
	}
}