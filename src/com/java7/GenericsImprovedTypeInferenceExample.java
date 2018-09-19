package com.java7;

import java.util.ArrayList;
import java.util.List;

public class GenericsImprovedTypeInferenceExample {

	public static void main(String args[])
	{
		/*
		 * 
		 * Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
			becomes:

			Map<String, List<String>> anagrams = new HashMap<>();
		 * 
		 */
		List<String> stringList = new ArrayList<>();
		stringList.add("Hai");
		stringList.add("Hello");
		
		//stringList.add(23);
		
		System.out.println(stringList);
	}
}
