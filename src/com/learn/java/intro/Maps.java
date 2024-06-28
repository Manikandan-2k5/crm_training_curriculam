package com.learn.java.intro;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Maps {
	
	public static void main(String[] args) {
		 Maps maps = new Maps();
		 //maps.hashMapFunctions();
		 //maps.linkedHashMapFunctions();
		 //maps.treeMapFunctions();
		 //maps.concurrentHashMapFunctions();
	}
	
	/**
	 * <p>Hash Map specific methods</p>
	 */
	public void hashMapFunctions() {
		//It is an unordered collection of key value pairs. Allows only one null key and multiple null values.
		HashMap<Integer, String> map = new HashMap<Integer, String>();// Initialises a new HashMap which has key value pairs, where key is integer data type and value is string data type.
		map.put(1, "America");// Puts an item{key:value} in the map. If the given key already exists, it replaces the value.
		map.put(2, "India");
		map.put(3, "Africa");
		map.put(4, "China");
		map.put(5, "Russia");
		map.put(11, null);
		System.out.println("Hash Map after adding items: "+map);
		HashMap<Integer, String> anotherMap = new HashMap<Integer, String>();
		anotherMap.put(6, "Singapore");
		anotherMap.put(7, "Japan");
		anotherMap.put(8, "UAE");
		anotherMap.put(9, "Denmark");
		anotherMap.put(10, "United Kingdom");
		anotherMap .put(4, "Pakistan");
		map.putAll(anotherMap);// Puts all the item in the given map. If the key in the given items of the given map argument is already present in the map, then the value is replaced.
		System.out.println("Hash Map after adding all the items in the given argument map: "+map);
		System.out.println("Value of key 5: "+map.get(5));//Prints the value of key 5. If the given key is not present, then it will return null.
		System.out.println("Is the hash map contains key 3: "+map.containsKey(3));
		System.out.println("Is the hash map contains value Russia: "+map.containsValue("Russia"));
		System.out.println("Size of the hash map: "+map.size());
		System.out.println("Is map empty: "+map.isEmpty());
		map.remove(1);//removes the item which has 1 as key.
		System.out.println("After removal of an item: "+map);
		Set<Integer> keySet = map.keySet();//returns the key set of the hash map.
		System.out.println("Key set of the map: "+keySet);
		Collection<String> valuesCollection = map.values();//returns the collection of values in the hash map.
		System.out.println("Values Collection of the map: "+valuesCollection);
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();//returns set of all the items in the hash map.
		System.out.println("\nLooping through the items and printing it.");
		for(Map.Entry<Integer, String> item : entrySet) {
			System.out.println(item.getKey()+" : "+item.getValue());
		}
		map.replace(3, "Nigeria");//Replaces the value of the given key if present in the hash map and returns the previous value, else no changes and returns null.
		System.out.println("\nHash map after replacement of the value of the key 3: "+map);
		map.replace(3, "Russia", "Malaysia");//Replaces the value of the given key key and corresponding old value with a new given new value only if the key is associated with the old value, else no changes. returns previous value if the above condition is true, else returns null.
		System.out.println("Hash map after replacement of the value of the key 3 with old value as Russia: "+map);
		map.putIfAbsent(11, "Dubai");//puts this item in the hash map only if the given key is not present in the item or it the give key's value is null.
		System.out.println("Hash Map after adding an item only if the key is absent or pointing to null value: "+map);
		map.compute(5, (key, value) -> value+"(New Location)");//computes the new value for the given key. If the given key is absent, null will be the value of the key and if the return value of the function is null, then the mapping will be removed.
		System.out.println("Hash map after compute method: "+map);
		map.computeIfPresent(11, (key, value) ->  value+"(Outdated Place)");//computes the new value for the given key only if the key is present in the hash map and has a non null value to it, else no changes will be there in hash map. If the return value of the function is null, the mapping will be removed from the hash map.
		System.out.println("Hash map after computeIfPresent method: "+map);
		map.computeIfAbsent(1, (key) -> "Maldives");//computes the value of the given key only if the given key is absent in the hash map or the given key is mapped to null. else there will be no changes. If the function returns null then the mapping will be removed.
		System.out.println("Hash map after computeIfAbsent method: "+map+"\n");
		// Performs a function on each item of the hash map.
		map.forEach((key, value) -> System.out.println(key+" : "+value));
		System.out.println();
		// replaces all the values of the items in the hash map.
		map.replaceAll((key, value) -> value+"(Location)");
		System.out.println("Hash map after replacing all the values: "+map);
		//merges two hash maps.
		map.merge(2, "Alaska", (old, updated) -> "["+old+", "+updated+"]");//if computed value is null then the mapping is removed.
		System.out.println("Hash map after merge method: "+map);
		System.out.println("Accessing value of the key 0: "+map.getOrDefault(0, "No key Found"));//returns value if the key is present, else returns the default message.
	}
	
	/**
	 * <p>Linked Hash Map specific methods</p>
	 */
	public void linkedHashMapFunctions() {
		//It is an ordered collection of key value pairs. Allows only one null key and multiple null values. Follows the order of insertion on access.
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(){
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
				return size() > 5;
			}
		};// Initialises a new LinkedHashMap which has key value pairs, where key is integer data type and value is string data type. If the length of the map exceeds 5 then the eldest element will be removed.
		map.put(1, "America");// Puts an item{key:value} in the map. If the given key already exists, it replaces the value.
		map.put(2, "India");
		map.put(3, "Africa");
		map.put(4, "China");
		map.put(5, "Russia");
		map.put(11, null);
		System.out.println("Linked Hash Map after adding items: "+map);
		HashMap<Integer, String> anotherMap = new HashMap<Integer, String>();
		anotherMap.put(6, "Singapore");
		anotherMap.put(7, "Japan");
		anotherMap.put(8, "UAE");
		anotherMap.put(9, "Denmark");
		anotherMap.put(10, "United Kingdom");
		anotherMap .put(4, "Pakistan");
		map.putAll(anotherMap);// Puts all the item in the given map. If the key in the given items of the given map argument is already present in the map, then the value is replaced.
		System.out.println("Linked Hash Map after adding all the items in the given argument map: "+map);
		System.out.println("Value of key 5: "+map.get(5));//Prints the value of key 5. If the given key is not present, then it will return null.
		System.out.println("Is the linked hash map contains key 3: "+map.containsKey(3));
		System.out.println("Is the linked hash map contains value Russia: "+map.containsValue("Russia"));
		System.out.println("Size of the linked hash map: "+map.size());
		System.out.println("Is map empty: "+map.isEmpty());
		map.remove(1);//removes the item which has 1 as key.
		System.out.println("After removal of an item: "+map);
		Set<Integer> keySet = map.keySet();//returns the key set of the linked hash map.
		System.out.println("Key set of the map: "+keySet);
		Collection<String> valuesCollection = map.values();//returns the collection of values in the linked hash map.
		System.out.println("Values Collection of the map: "+valuesCollection);
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();//returns set of all the items in the linked hash map.
		System.out.println("\nLooping through the items and printing it.");
		for(Map.Entry<Integer, String> item : entrySet) {
			System.out.println(item.getKey()+" : "+item.getValue());
		}
		map.replace(3, "Nigeria");//Replaces the value of the given key if present in the hash map and returns the previous value, else no changes and returns null.
		System.out.println("\nLinked Hash map after replacement of the value of the key 3: "+map);
		map.replace(3, "Russia", "Malaysia");//Replaces the value of the given key key and corresponding old value with a new given new value only if the key is associated with the old value, else no changes. returns previous value if the above condition is true, else returns null.
		System.out.println("Linked Hash map after replacement of the value of the key 3 with old value as Russia: "+map);
		map.putIfAbsent(11, "Dubai");//puts this item in the hash map only if the given key is not present in the item or it the give key's value is null.
		System.out.println("Linked Hash Map after adding an item only if the key is absent or pointing to null value: "+map);
		map.compute(5, (key, value) -> value+"(New Location)");//computes the new value for the given key. If the given key is absent, null will be the value of the key and if the return value of the function is null, then the mapping will be removed.
		System.out.println("Linked Hash map after compute method: "+map);
		map.computeIfPresent(11, (key, value) ->  value+"(Outdated Place)");//computes the new value for the given key only if the key is present in the hash map and has a non null value to it, else no changes will be there in hash map. If the return value of the function is null, the mapping will be removed from the hash map.
		System.out.println("Linked Hash map after computeIfPresent method: "+map);
		map.computeIfAbsent(1, (key) -> "Maldives");//computes the value of the given key only if the given key is absent in the hash map or the given key is mapped to null. else there will be no changes. If the function returns null then the mapping will be removed.
		System.out.println("Linked Hash map after computeIfAbsent method: "+map+"\n");
		// Performs a function on each item of the hash map.
		map.forEach((key, value) -> System.out.println(key+" : "+value));
		System.out.println();
		// replaces all the values of the items in the linked hash map.
		map.replaceAll((key, value) -> value+"(Location)");
		System.out.println("Linked Hash map after replacing all the values: "+map);
		//merges two hash maps.
		map.merge(2, "Alaska", (old, updated) -> "["+old+", "+updated+"]");//if computed value is null then the mapping is removed.
		System.out.println("Linked Hash map after merge method: "+map);
		System.out.println("Accessing value of the key 0: "+map.getOrDefault(0, "No key Found"));//returns value if the key is present, else returns the default message.
	}
	
	/**
	 * <p>Tree Map specific methods</p>
	 */
	public void treeMapFunctions() {
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();//It is a sorted map, which does not allow null keys but accepts null values. Its sorts the array based on the compareTo method of Comparable Interface or compare method of the comparator.
		treeMap.put(4, "China");
		treeMap.put(5, "Russia");
		treeMap.put(1, "America");
		treeMap.put(2, "India");
		treeMap.put(3, "Africa");
		System.out.println("Sorted Tree Map according to the compareTo method of the comparable interface: "+treeMap);
		Comparator<Integer> descendingComparator = (num1, num2) -> num2-num1;
		TreeMap<Integer, String> treeMap2 = new TreeMap<Integer, String>(descendingComparator);//Initialising the tree map with descending comparator so all the elements will be sorted in descending order.
		treeMap2.put(4, "China");
		treeMap2.put(5, "Russia");
		treeMap2.put(1, "America");
		treeMap2.put(2, "India");
		treeMap2.put(3, "Africa");
		System.out.println("Sorted Tree Map according to the compare method of the comparator interface: "+treeMap2);
		System.out.println("Prints the key of the first entry in tree map: "+treeMap.firstKey());
		System.out.println("Prints the key of the last entry in tree map: "+treeMap.lastKey());
		System.out.println("Prints the first entry in tree map: "+treeMap.firstEntry());
		System.out.println("Prints the last entry in tree map: "+treeMap.lastEntry());
		System.out.println("Prints and removes the first entry in tree map: "+treeMap.pollFirstEntry());
		System.out.println("Prints and removes the last entry in tree map: "+treeMap.pollLastEntry());
		System.out.println("Tree Map after polling: "+treeMap);
		System.out.println("Prints the tree map in descending order: "+treeMap.descendingMap());
		System.out.println("Prints the keySet of the tree map in descending order: "+treeMap.descendingKeySet());
		System.out.println("Prints the Navigable set of the entries in the tree map: "+treeMap.navigableKeySet());
		System.out.println("Prints the submap from the tree map: "+treeMap.subMap(2, true, 4, true));//Both from and to are inclusive as the booleans are true.
		System.out.println("Prints the head map from the given key in the given tree map: "+treeMap.headMap(4, true)); //boolean true makes the given key inclusive.
		System.out.println("Prints the tail map from the given key in the given tree map: "+treeMap.tailMap(4, false)); //boolean true makes the given key inclusive.
		System.out.println("Prints the entry which has the greatest possible key which is less than the given key: "+treeMap.lowerEntry(5));
		System.out.println("Prints the entry which has the least possible key which is greater than the given key: "+treeMap.higherEntry(2));
		System.out.println("Prints the entry which has the greatest possible that is lesser than or equal to the given key: "+treeMap.floorEntry(5));
		System.out.println("Prints the entry which has the least possible key that is greater than or equal to the given key: "+treeMap.ceilingEntry(2));
		System.out.println("Prints the key which is the greatest possible key that is less than the given key: "+treeMap.lowerKey(5));
		System.out.println("Prints the key which is the least possible key that is greater than the given key: "+treeMap.higherKey(2));
		System.out.println("Prints the key which is the greatest possible key that is less than or equal to the given key: "+treeMap.floorKey(5));
		System.out.println("Prints the key which is the least possible key that is greater than or equal to the given key: "+treeMap.ceilingKey(2));
	}
	
	/**
	 * <p>Difference between Concurrent Hash Map and normal Hash Map</p>
	 */
	public void concurrentHashMapFunctions() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "Mani");
		ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<Integer, String>();
		concurrentMap.put(1, "Mani");
		concurrentMap.forEach((key, value) -> concurrentMap.put(5, "Manikandan"));//fail safe
		System.out.println("Concurrent Hash Map(Fail Safe): "+concurrentMap);
		System.out.println("Hash Map(Fail Fast)");
		hashMap.forEach((key, value) -> hashMap.put(5, "Manikandan"));//fail fast
	}
}
