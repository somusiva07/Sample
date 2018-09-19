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

public class JMSConnectionClient{
	
	public static void main(String args[]){
		
		//JmsConfiguration jmsConfig = new JmsConfiguration();
		MQConnectionFactory cf = new MQConnectionFactory();
		try
        {
			cf.setHostName("memd01.airservices.eds.com");
            cf.setPort(1418);
            cf.setBrokerQueueManager("MEMD01");
            cf.setChannel("EMD.MEMD01");
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
            //Queue queue = session.createQueue("queue://MEMD01/SOA.EMD.RS.SHARESA.TYPEA?targetClient=1");
            Queue queue = session.createQueue("queue://MEMD01/SOA.EMD.RS.SHARESA.TYPEA?targetClient=1");
            MessageProducer mp = session.createProducer(queue);
            //MessageConsumer mc = session.createConsumer(queue);
            connection.start();
            /*while (true) {
                TextMessage textMsg = (TextMessage) mc.receive();
                System.out.println(textMsg);
                System.out.println("Received: " + textMsg.getText());
                if (textMsg.getText().equals("END")) {
                    break;
                }
            }*/	
            //Message m = mc.receive();
            /*Message m = session.createTextMessage("UNB+IATB:1+99+UA+20180327:1558+96E74C9D0001+96E74C9D0001++T'"
            		+ "UNH+001+TKCRES:08:1:IA'MSG+:792+3'EQN+1:TD'TIF+ADAMS+JOHN'TAI+1171+PJ:B'RCI+:DC6Q13:1'"
            		+ "MON+B::EUR+T::EUR'FOP+CA'PTK+++121212'FTI+SK:2547324528'EQN+2:TF'IFT+4:10+NON-REFUNDABLE'"
            		+ "IFT+4:15:0+STO SK PAR 25.00 AF NCE 25.00 EUR50.00END ROE 1.00'IFT+4:733:0'IFT+4:45'"
            		+ "IFT+4:39+SCANDANAVIAN+STOCKHOLM SE'TKT+0162120218113:J::2'CPN+1'TKT+0162120234533:J::3'"
            		+ "CPN+1::25'TVL++ARN+CDG+SK'DAT+B:121208+A:280209+1'CPN+2::25'TVL++CDG+NCE+AF'DAT+B:120908+A:280209+1'"
            		+ "TKT+0162120234533:J::::0167980234989'UNT+27+0'UNZ+1+96E74C9D0001'");*/
            
            Message m = session.createTextMessage("UNB+IATB:1+99+UA+20180327:1558+96E74C9D0001+96E74C9D0001++T'"
            		+ "UNH+001+TKCRES:08:1:IA'MSG+:792+3'ORG++++++::XX'EQN+1:TD'UNT+5+001'UNZ+1+96E74C9D0001'");

            mp.send(m);
            System.out.println("Message Rxed Successfully.....");
            
            

        } catch (JMSException ex)
        {
            System.out.println("Exception Occured..... "+ex.getMessage());
        }
		
		
	}
	
}