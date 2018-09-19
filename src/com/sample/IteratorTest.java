package com.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String args[])
	{
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		
		System.out.println(list.size());
		
		Iterator<String> iterator = list.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println("Current obj is : "+iterator.next());
			iterator.remove();
		}
		System.out.println("After removal : "+list.size());
	}
}
