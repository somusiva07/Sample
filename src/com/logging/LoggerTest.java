package com.logging;

import org.apache.log4j.Logger;

public class LoggerTest {

	final static Logger logger = Logger.getLogger(LoggerTest.class);
	
	public static void main(String at[]){
		logger.trace("Hai trace");
		logger.debug("Hai debug");
		logger.info("Hai info");
		logger.warn("Hai warn");
		logger.error("Hai error");
		logger.fatal("Hai fatal");
		
	}
	
}
