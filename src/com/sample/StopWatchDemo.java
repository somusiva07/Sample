package com.sample;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchDemo {

	public static void main(String args[]) throws InterruptedException
	{
		StopWatch watch = new StopWatch();
		watch.start();
		
		Thread.sleep(5000);

		watch.stop();
		
		System.out.println(watch.getTime()/1000);
	}
}
