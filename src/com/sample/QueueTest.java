package com.sample;

public class QueueTest {

	private static final CharSequence EMPTY_STRING = "";
	private static final String COLON = ":";

	public static void main(String args[])
	{
		String[] inputQueues = new String("SOA.${UA}.EMD.RQ.SHARES.INTERLINE,TST.${Z2}.EMD.RQ.SHARES.INTERLINE.MB").split(",");
		String testQueueName = "TST.Z2.EMD.RQ.SHARES.INTERLINE";
		if("queue:///TST.Z2.EMD.RQ.SHARES.INTERLINE.MB?mdReadEnabled=true&mdWriteEnabled=true".contains(testQueueName))
		{
			System.out.println("prepareInterlineJMSConfiguration : airlineVendorID : ");
		}
		
		for (int inputQueueIndex = 0; inputQueueIndex < inputQueues.length; inputQueueIndex++)
        {
			if (inputQueues[inputQueueIndex].contains("${"))
	        {
	            String temp =
	                inputQueues[inputQueueIndex]
	                        .substring(inputQueues[inputQueueIndex].indexOf("{")-1, inputQueues[inputQueueIndex].lastIndexOf("}") + 1);
	            System.out.println("prepareInterlineJMSConfiguration : temp : "+temp);
	            String[] airlineVendorIDs =
	                temp.replace("${", EMPTY_STRING).replace("}", EMPTY_STRING)
	                        .split(COLON);
	            for (String airlineVendorID : airlineVendorIDs)
	            {
	            	System.out.println("prepareInterlineJMSConfiguration : airlineVendorID : "+airlineVendorID);
	                String inputQueue =
	                    inputQueues[inputQueueIndex].replace(temp.trim(), airlineVendorID);
	                System.out.println("prepareInterlineJMSConfiguration : inputQueue : "+inputQueue);
	            }

	        }
        }
		
	}
	
}
