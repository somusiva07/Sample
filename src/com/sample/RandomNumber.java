package com.sample;

import java.util.Random;

public class RandomNumber {

	public static void main(String args[])
	{
		System.out.println(randomNoGenerator());
		
		/*String unh = "UNH+001+TKCREQ:08:1:IA'+05rth";
		String unhArray[] = unh.split("\\+");
		System.out.println(unhArray.length);*/
	}
	
	private static Integer baseIntForRandom = 300000000;
	
	private static String randomNoGenerator()
    {
        Random generator = new Random();
        int incrementRandom = generator.nextInt(30);
        baseIntForRandom = baseIntForRandom + incrementRandom;
        String hex = Integer.toHexString(baseIntForRandom);
        return "00" + hex;
    }
}
