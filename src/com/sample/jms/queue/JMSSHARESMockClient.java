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

public class JMSSHARESMockClient{
	
	public static void main(String args[]){
		
		//JmsConfiguration jmsConfig = new JmsConfiguration();
		MQConnectionFactory cf = new MQConnectionFactory();
		try
        {
			cf.setHostName("memd01.airservices.eds.com");
            cf.setPort(1418);
            cf.setBrokerQueueManager("MEMD01");
            cf.setChannel("EMD.MEMD01");
            System.out.println("Q Manager : waiting for msg : "+cf.getQueueManager());
            cf.setTransportType(JMSC.MQJMS_CLIENT_NONJMS_MQ);
            cf.setStringProperty(WMQConstants.JMS_IBM_CHARACTER_SET, "500");
            cf.setStringProperty(WMQConstants.JMS_IBM_FORMAT, MQC.MQFMT_STRING);
            cf.setIntProperty(WMQConstants.JMS_IBM_ENCODING, 273);
            cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CLIENT_NONJMS_MQ);
            cf.setTargetClientMatching(true);
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //Queue req = session.createQueue("queue://MEMD01/TST.Z2.EMD.RQ.SHARES.INTERLINE.MB?targetClient=1");
            Queue req = session.createQueue("queue://MEMD01/SOA.UA.EMD.RQ.SHARES.INTERLINE?targetClient=1");
            MessageConsumer mc = session.createConsumer(req);
            
            //Queue res = session.createQueue("queue://MEMD01/TST.Z2.SHARES.RS.EMD.INTERLINE.MB?targetClient=1");
            Queue res = session.createQueue("queue://MEMD01/SOA.UA.SHARES.RS.EMD.INTERLINE?targetClient=1");
            MessageProducer mp = session.createProducer(res);
         
            //MessageConsumer msgres = session.createConsumer(res);
            
            connection.start();
            /*while (true) {
                TextMessage textMsg = (TextMessage) mc.receive();
                System.out.println("Received from Req queue : " + textMsg.getText());
                
                Message m = session.createTextMessage(textMsg.getText());
                mp.send(m);
                System.out.println("Message Sent Successfully.....");
                
                
                TextMessage resMsg = (TextMessage) msgres.receive();
                System.out.println("Received from Res queue : " + resMsg .getText());
            }*/	
            
            TextMessage textMsg = (TextMessage) mc.receive();
            System.out.println("Received from Req queue : " + textMsg.getText());
            
            Message m = session.createTextMessage(textMsg.getText()+"hello");
            mp.send(m);
            System.out.println("Message Sent Successfully.....Client");
            
            
            /*TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText());*/
            
            
            mc.close();
            mp.close();
            session.close();
            connection.close();
            
        } catch (JMSException ex)
        {
        	ex.printStackTrace();
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		
		
		
	}
	
}