package com.sample.jms.queue.tb;

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

public class JMSConnection_CLT_TypeA_Reciever_Sender {
public static void main(String args[]){
		
	//String clt2tul_TG [] = {"TST.CLT.EMD.RQ.EMD.INITIATED.TG","TST.CLT.EMD.RS.EMD.INITIATED.TG","TST.TUL.EMD.RQ.EMD.TYPEA.TG","TST.TUL.EMD.RS.EMD.TYPEA.TG"};
	
	
	//ustlssoat180.airservices.svcs.entsvcs.net

	
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
            Queue res = session.createQueue("queue://TEMD01/TST.CLT.EMD.RQ.EMD.TYPEA.TB?targetClient=1");
            MessageConsumer msgres = session.createConsumer(res);
            
            TextMessage resMsg = (TextMessage) msgres.receive();
            System.out.println("Received from Res queue : " + resMsg .getText()+" : correlation id is : "+resMsg.getJMSCorrelationID());
            
            
            
            Queue queue = session.createQueue("queue://TEMD01/TST.CLT.EMD.RS.EMD.TYPEA.TB?targetClient=1");
            MessageProducer mp = session.createProducer(queue);
            
            String  edifactMessage = "Test Message from CLT - TB";
            
            TextMessage m = session.createTextMessage(edifactMessage);
            m.setJMSCorrelationID("1YUA12345678900987654321");
            mp.send(m);
            System.out.println("Message Sent Successfully.....Server");
            
            connection.start();
            
           

            
            mp.close();
            msgres.close();
            session.close();
            connection.close();
            
        } catch (Exception ex)
        {
        	ex.printStackTrace();
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
	}
}
