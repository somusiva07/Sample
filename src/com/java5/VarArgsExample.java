package com.java5;

public class VarArgsExample {

	public static void main(String[] args) {
		
		myVarArgs("a","b","c");
		myCustomVarArgs("a",'b',"c",1,2.0);

	}

	private static void myCustomVarArgs(Object...obj) {
		for(Object object : obj)
		{
			System.out.println(object);
		}
		
	}

	private static void myVarArgs(String... string) {
		
		for(String str : string)
		{
			System.out.println(str);
		}
		
	}

}
