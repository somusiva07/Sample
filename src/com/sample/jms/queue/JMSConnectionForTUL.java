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

public class JMSConnectionForTUL{
	
	public static void main(String args[]){
		
		//JmsConfiguration jmsConfig = new JmsConfiguration();
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
            //Queue queue = session.createQueue("queue://MEMD01/TST.Z2.EMD.RQ.SHARES.INTERLINE.MB?targetClient=1");
            //Queue queue = session.createQueue("queue://MEMD01/SOA.UA.EMD.RQ.SHARES.INTERLINE?targetClient=1");
            /*
             * CM Queue for TUL
             */
            
            Queue queue = session.createQueue("queue://MEMD01/SOA.CM.EMD.RQ.SHARES.INTERLINE?targetClient=1");
            /*MessageConsumer mc = session.createConsumer(queue);
            connection.start();*/
            MessageProducer mp = session.createProducer(queue);
            //String  edifactMessage = "UNB+Z2+UA+171023:1200+007530'UNH+1+TKCREQ:IATA2010:2:IA+Z27530'MSG+:791'ORG+AA:DFW+12345678+DAL++A+US:USD+dev.agent.Z2'TKT+0014550062393'FOP+CC'UNT+6+0'UNZ+1+007530'UNZ+1+007530'";
            //String  edifactMessage = "UNB+IATA:1+UA+CM+180103:1200+007530'UNH+0+TKCREQ:08:1:IA'MSG+:791'ORG+UA:MUC+79527604:051606+GYE++T+EC:USD+A1912KRSU'TKT+0163011484636'FOP+CC'UNT+6+0'UNZ+1+007530'";
            //String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKTREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+UA+91500021:B5LC+LIM++T+PE:PEN+AJW'TKT+2303012075278'UNT+5+1'UNZ+1+1'";

            //Sample 1
            //String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+86510756:8WE7+MEX++T+MX:MXN+AMQ'TKT+0163012176606'UNT+5+1'UNZ+1+1'";
            //Sample 2
            //String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+69553083:BB50+YUL++T+CA:CAD+AU1'TKT+0163015502977'UNT+5+1'UNZ+1+1'";
            
            String  edifactMessage = "UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+69553083:BB50+YUL++T+CA:CAD+AU1'TKT+0163015502977'UNT+5+1'UNZ+1+1'";
            
            TextMessage m = session.createTextMessage(edifactMessage);
            m.setJMSCorrelationID("CMUA12345678900987654321");
            mp.send(m);
            System.out.println("Message Sent Successfully.....Server");
            
            connection.start();
            
            //Queue res = session.createQueue("queue://MEMD01/TST.Z2.SHARES.RS.EMD.INTERLINE.MB?targetClient=1");
            Queue res = session.createQueue("queue://MEMD01/SOA.CM.SHARES.RS.EMD.INTERLINE?targetClient=1");
            MessageConsumer msgres = session.createConsumer(res);
            
            TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText()+" : correlation id is : "+resMsg.getJMSCorrelationID());

            
            mp.close();
            msgres.close();
            session.close();
            connection.close();
            
        } catch (JMSException ex)
        {
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		
		
	}
	
}