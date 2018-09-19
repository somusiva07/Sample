package com.java5;

public class AutoBoxingUnBoxingExample {

	public static void main(String arg[])
	{
		Integer integer = 4;
		//Integer integer = new Integer(4);
		//int i = integer.intValue();//not reqd
		int i = integer;
		
		System.out.println(integer);
		integer++;//it is possible on wrapper type too
		System.out.println(integer);
		System.out.println(i);
		System.out.println(i+integer);
		
		//Not reqd..
		//Boolean stuff = new Boolean(false);
		// stuff before ? must be a boolean (lower case)
		//System.out.println( stuff.booleanValue() ? "Yep" : "Nope" );
		
		Boolean stuff = false;
		System.out.println( stuff ? "Yep" : "Nope" );
		
		
	}
}
