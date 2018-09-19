package com.sample;

public class ModuloOpr {

	public static void main(String args[])
	{
		int strCount = 2500;
		int limit = 1000;
		
		for (int strIndex = 0; strIndex < strCount; strIndex++) {
			if (strIndex % limit != 0) {
				System.err.println(" strIndex : "+strIndex+" : limit : "+limit);
			}
			System.err.println("Outside Loop : ");	
		}
		
	}
}
