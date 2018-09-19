package com.sample;

public class ArrayTest {

	public static void main(String[] args) {
		String version = "1";
		String[] releaseVersion = version.split("\\.");
        if(null!=releaseVersion[0])
        {
        	System.out.println("One");
        }
        if(null!=releaseVersion[1])
        {
        	System.out.println("Two");
        }

	}

}
