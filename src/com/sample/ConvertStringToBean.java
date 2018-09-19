package com.sample;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

public class ConvertStringToBean {

	
	public static void main(String args[]) throws IllegalAccessException, InvocationTargetException
	{
		/*String model = new String("Somasundaram, 6008L, HPE, 28, 988452345, somu_siva@yahoo.com");
		String empClass = new String("empName,empId,company,age,contactNo,emailId");
		
        String[] modelValues = model.split(", ");
        String[] employeeParams = empClass.split(",");
        
        Employee employee = new Employee();

        for (int cnt=0; cnt<modelValues.length;cnt++) {

            String fieldName = employeeParams[cnt];
            String fieldValue = modelValues[cnt];

            BeanUtils.setProperty(employee, fieldName, fieldValue);
        }

        System.out.println(employee.toString());*/
		
		
		/*String str = "20160101024500+0220160101030000+020.048";
		
		System.out.println(str.substring(0, 8));
		
		System.out.println(str.substring(8, 14));
		System.out.println(str.substring(14, 17));
		
		//day to
		System.out.println(str.substring(17, 25));
		System.out.println(str.substring(25, 31));
		System.out.println(str.substring(31, 34));
		
		System.out.println(str.substring(34, str.length()));*/
		
		
		
		Long start = System.currentTimeMillis();
		// create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("C://Users/arunacso/Documents/My Received Files/mapping.xml");
        
        // use a StreamFactory to create a BeanReader
        /*BeanReader in = factory.createReader("employeeFile", new File("C://Users/arunacso/Documents/My Received Files/employee.csv"));
        Employee employee;
        while ((employee = (Employee) in.read()) != null) {
            // process the employee...
        	System.out.println(employee.employeeName);
        }*/
        
        BeanReader in = factory.createReader("employeeFile", new File("C://Users/arunacso/Documents/My Received Files/DataBook5.csv"));
        Loproma loproma;
        long l = 0;
        while ((loproma = (Loproma) in.read()) != null) {
            // process the employee...
        	l++;
        	System.out.println(loproma.getPod()+": fro Date : "+loproma.getFromDate());
        }
        
        in.close();
        Long end = System.currentTimeMillis();
        
        System.err.println(end-start);
		
	}
}
