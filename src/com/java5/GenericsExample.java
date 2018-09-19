package com.java5;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

	public static void main(String args[])
	{
		List<String> stringList = new ArrayList<String>();
		stringList.add("Hai");
		stringList.add("Hello");
		
		//stringList.add(23);
		
		System.out.println(stringList);
	}
}
