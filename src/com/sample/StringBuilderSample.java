package com.sample;


import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StringBuilderSample {

	public static void main(String args[])
	{
		/*String str = "<air:PingResponse>\r\n               <air:Application>{0}</air:Application>\r\n               <air:Measurements>\r\n                  <air:Measurement>\r\n                     <air:Name>SERVICE_START_TIME</air:Name>\r\n                     <air:Value>{1}</air:Value>\r\n                  </air:Measurement>\r\n                  <air:Measurement>\r\n                     <air:Name>SERVICE_END_TIME</air:Name>\r\n                     <air:Value>{2}</air:Value>\r\n                  </air:Measurement>\r\n               </air:Measurements>\r\n               <air:Processes>\r\n                  <air:Process>\r\n                     <air:Name>Interline - ping()</air:Name>\r\n                     <air:Status>SUCCESS</air:Status>\r\n                  </air:Process>\r\n               </air:Processes>\r\n            </air:PingResponse>";
		MessageFormat mf = new  MessageFormat(str);
		Object[] objArray = {"Translator Interline",new Date(), new Date()};
		String message = mf.format(objArray);
		
		System.out.println("The message: \n"+message);*/
		
		/*String str = null;
		StringBuilder sb = new StringBuilder("Hello");
		sb.append(str);
		sb.append("Hai");
		System.out.println(sb.toString());
		if(sb.toString().contains("null"))
		{
			System.out.println(sb.toString());
		}*/
		
		String str = "0123456SER7890asd2";
		String str1 = "878";
		String replacedString = str.replaceAll("[0-9,a-z,A-Z]", "x").substring(0, str.length()-str1.length()).concat(str1);
		
		System.out.println(replacedString);
	}
	
}
