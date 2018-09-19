package com.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {

	public static void main(String[] args) {

		/*
		 * BufferedReader br = new BufferedReader(new FileReader(path));
			try {
   				return br.readLine();
			} finally {
   			br.close();
			}
		 */
		try (BufferedReader br = new BufferedReader(new FileReader("C:/camera.log"))) {
			while(null!=br.readLine())
			   System.out.println(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		/*
		 * 
		 * You can declare more than one resource to close:

			try (
			   InputStream in = new FileInputStream(src);
			   OutputStream out = new FileOutputStream(dest))
			{
			 // code
			}
		 * 
		 */

	}

}
