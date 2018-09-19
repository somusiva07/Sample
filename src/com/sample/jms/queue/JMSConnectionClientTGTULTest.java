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

public class JMSConnectionClientTGTULTest{
	
	public static void main(String args[]){
		
		//JmsConfiguration jmsConfig = new JmsConfiguration();
		MQConnectionFactory cf = new MQConnectionFactory();
		try
        {
			cf.setHostName("ustlssoat180.airservices.svcs.entsvcs.net");
            cf.setPort(1418);
            cf.setBrokerQueueManager("TEMD01");
            cf.setChannel("EMD.TEMD01");
            System.out.println("Q Manager : "+cf.getQueueManager());
            cf.setTransportType(JMSC.MQJMS_CLIENT_NONJMS_MQ);
            cf.setStringProperty(WMQConstants.JMS_IBM_CHARACTER_SET, "500");
            cf.setStringProperty(WMQConstants.JMS_IBM_FORMAT, MQC.MQFMT_STRING);
            cf.setIntProperty(WMQConstants.JMS_IBM_ENCODING, 273);
            cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CLIENT_NONJMS_MQ);
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //Queue queue = session.createQueue("queue://MEMD01/TST.Z2.EMD.RQ.SHARES.INTERLINE.MB?targetClient=1");
            //Queue queue = session.createQueue("queue://MEMD01/SOA.UA.SHARES.RS.EMD.INTERLINE?targetClient=1");
            //Queue queue = session.createQueue("queue://TEMD01/TST.Z2.SHARES.RQ.GDSEMD.TYPEA.TG?targetClient=1");
            Queue res = session.createQueue("queue://TEMD01/TST.TUL.EMD.RS.EMD.INITIATED.TG?targetClient=1");
            MessageConsumer msgres = session.createConsumer(res);
            connection.start();
            TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText()+" : correlation id is : "+resMsg.getJMSCorrelationID());
            //MessageProducer mp = session.createProducer(queue);
            //MessageConsumer mc = session.createConsumer(queue);
            
            /*while (true) {
                TextMessage textMsg = (TextMessage) mc.receive();
                System.out.println(textMsg);
                System.out.println("Received: " + textMsg.getText());
                if (textMsg.getText().equals("END")) {
                    break;
                }
            }*/	
            //Message m = mc.receive();
            /*Message m = session.createTextMessage("UNB+IATA:1+CM+UA+180221:1803+0FRK0D29050001'UNH+2745+TKCREQ:08:1:IA+E3E59DC6D295'MSG+:791'ORG+CM+69553083:BB50+YUL++T+CA:CAD+AU1'TKT+0163015502977'UNT+5+1'UNZ+1+1'");
            mp.send(m);
            System.out.println("Message Rxed Successfully.....");*/
            
            

        } catch (JMSException ex)
        {
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		catch (Exception e)
        {
            System.out.println("Exception Occured..... "+e.getMessage());
        }
		
		
	}
	
}