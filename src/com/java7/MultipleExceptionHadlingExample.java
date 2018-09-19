package com.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultipleExceptionHadlingExample {

	public static void main(String[] args) {

		/*
		 * } catch (FirstException ex) {
			     logger.error(ex);
			     throw ex;
			} catch (SecondException ex) {
			     logger.error(ex);
			     throw ex;
			}
		 * 
		 */
		try (BufferedReader br = new BufferedReader(new FileReader("C:/camera.log"))) {
			while(null!=br.readLine())
			   System.out.println(br.readLine());
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
	}

}
