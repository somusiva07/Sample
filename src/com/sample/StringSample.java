package com.sample;

public class StringSample {

	public static void main(String[] args) {
		
		String correlationId = "UACM12345678901234567890";
		
		if(correlationId.substring(0, 2).equalsIgnoreCase("UA"))
    	{
    		System.out.println("Sending Carrier : "+ correlationId.substring(0, 2));
    	}
    	if(correlationId.substring(2, 4).equalsIgnoreCase("CM"))
    	{
    		System.out.println("Receiving Carrier : "+ correlationId.substring(2, 4));
    	}

	}

}
