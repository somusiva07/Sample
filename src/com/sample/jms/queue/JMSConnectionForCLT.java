package com.sample.jms.queue;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.msg.client.wmq.v6.base.internal.MQC;
import com.ibm.msg.client.wmq.v6.jms.internal.JMSC;

public class JMSConnectionForCLT{
	
	public static void main(String args[]){
		
		MQConnectionFactory cf = new MQConnectionFactory();
		try
        {
			cf.setHostName("usclssoat180.airservices.eds.com");
            cf.setPort(1418);
            cf.setBrokerQueueManager("TEMD01");
            cf.setChannel("EMD.TEMD01");
            System.out.println("Q Manager : "+cf.getQueueManager());
            cf.setTransportType(JMSC.MQJMS_CLIENT_NONJMS_MQ);
            cf.setStringProperty(WMQConstants.JMS_IBM_CHARACTER_SET, "500");
            cf.setStringProperty(WMQConstants.JMS_IBM_FORMAT, MQC.MQFMT_STRING);
            cf.setIntProperty(WMQConstants.JMS_IBM_ENCODING, 273);
            cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CLIENT_NONJMS_MQ);
            cf.setTargetClientMatching(true);
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            /*Queue res = session.createQueue("queue://TEMD01/TST.CLT.EMD.RS.EMD.TYPEA.TG?targetClient=1");
            MessageConsumer msgres = session.createConsumer(res);
            
            TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText()+" : correlation id is : "+resMsg.getJMSCorrelationID());*/
            
            
            
            Queue queue = session.createQueue("queue://TEMD01/TST.CLT.EMD.RS.EMD.TYPEA.TG?targetClient=1");
            MessageProducer mp = session.createProducer(queue);
            
            String  edifactMessage = "UNB+IATA:1+UA+1Y+180117:1212+00753c'UNH+1+TKTRES:08:1:IA+1YUA51F7293B61C96BF55E17'MSG+:791+7'ERC+401'UNT+4+0'UNZ+1+02111452226108'";
            
            TextMessage m = session.createTextMessage(edifactMessage);
            m.setJMSCorrelationID("1YUA12345678900987654321");
            mp.send(m);
            System.out.println("Message Sent Successfully.....Server");
            
            connection.start();
            
           

            
            mp.close();
            //msgres.close();
            session.close();
            connection.close();
            
        } catch (Exception ex)
        {
        	ex.printStackTrace();
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		
		
	}
	
}