package com.sample.jms.queue;

import javax.jms.Connection;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.ibm.msg.client.wmq.v6.base.internal.MQC;
import com.ibm.msg.client.wmq.v6.jms.internal.JMSC;

public class JMSConnection1YTesting {
	
	public static void main(String args[]){
		
		MQConnectionFactory cf = new MQConnectionFactory();
		try
        {
			cf.setHostName("memd01.airservices.svcs.entsvcs.net");
            cf.setPort(1418);
            cf.setBrokerQueueManager("MEMD01");
            cf.setChannel("EMD.MEMD01");
            System.out.println("Q Manager : "+cf.getQueueManager());
            cf.setTransportType(JMSC.MQJMS_CLIENT_NONJMS_MQ);
            cf.setStringProperty(WMQConstants.JMS_IBM_CHARACTER_SET, "500");
            cf.setStringProperty(WMQConstants.JMS_IBM_FORMAT, MQC.MQFMT_STRING);
            cf.setIntProperty(WMQConstants.JMS_IBM_ENCODING, 273);
            cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CLIENT_NONJMS_MQ);
            cf.setTargetClientMatching(true);
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            /*
             * 1Y Queue for TUL
             */
            
            Queue queue = session.createQueue("queue://MEMD01/SOA.1Y.EMD.RQ.SHARES.INTERLINE?targetClient=1");
            MessageProducer mp = session.createProducer(queue);
            
            //Sample 1
            //String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+86510756:8WE7+MEX++T+MX:MXN+AMQ'TKT+0163012176606'UNT+5+1'UNZ+1+1'";
            //Sample 2
            //String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+69553083:BB50+YUL++T+CA:CAD+AU1'TKT+0163015502977'UNT+5+1'UNZ+1+1'";
            
            String  edifactMessage = "UNB+IATA:1+1Y+UA+180117:1212+007546'UNH+1+TKTREQ:08:1:IA+UA7546'MSG+:791'ORG+1Y:MUC+11111111:301017+ZRH++T+CH:CHF:EN+A0001AASU'TKT+5361813323040'UNT+5+1'UNZ+1+1'";
            //String  edifactMessage = "UNB+IATA:1+1Y+CX+130820:0349+1'UNH+1+TKTREQ:08:1:IA+093B3130001B03'MSG+:791'ORG+1Y:MUC+99999999:301017+ZRH++T+CH:CHF:EN+A0001AASU'TKT+0161813422041'UNT+5+1'UNZ+1+1'";

            TextMessage m = session.createTextMessage(edifactMessage);
            m.setJMSCorrelationID("1YUA12345678900987654334");
            mp.send(m);
            System.out.println("Message Sent Successfully.....Server");
            
            connection.start();
            
            //Queue res = session.createQueue("queue://MEMD01/TST.Z2.SHARES.RS.EMD.INTERLINE.MB?targetClient=1");
            Queue res = session.createQueue("queue://MEMD01/SOA.1Y.SHARES.RS.EMD.INTERLINE?targetClient=1");
            MessageConsumer msgres = session.createConsumer(res);
            
            TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText()+" : correlation id is : "+resMsg.getJMSCorrelationID());

            
            mp.close();
            msgres.close();
            session.close();
            connection.close();
            
        } catch (Exception ex)
        {
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		
		
	}
	
}