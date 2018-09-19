package com.sample;

import java.util.ArrayList;
import java.util.List;

public class QueueEndpointTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> endPoint = new ArrayList<String>();
		endPoint.add("TEMD01://TST.Z2.SHARES.RQ.GDSEMD.TYPEA.TG?concurrentConsumers=15&disableReplyTo=true&maxConcurrentConsumers=24&preserveMessageQos=true&useMessageIDAsCorrelationID=true");
		endPoint.add("TEMD01://TST.Z2.SHARES.RQ.GDSEMD.TYPEA.TA?concurrentConsumers=15&disableReplyTo=true&maxConcurrentConsumers=24&preserveMessageQos=true&useMessageIDAsCorrelationID=true");
		endPoint.add("TEMD01://TST.Z2.EMD.RQ.SHARES.INTERLINE.TG?concurrentConsumers=15&disableReplyTo=true&maxConcurrentConsumers=24&preserveMessageQos=true&useMessageIDAsCorrelationID=true");
		
	
		for(String str : endPoint)
		{
			if(str.contains("INTERLINE"))
			{
				System.out.println("Found");
			}
			else
			{
				System.out.println("Not Found");
			}
		}
	}

}
