package com.sample;

import com.altova.io.StringInput;
import com.altova.io.StringOutput;

import net.hp.tr.purchase.message.emd.gds.mapper.acosrq_2010_2tov8_1.AcosRqMapToTKCREQ;
import net.hp.tr.purchase.message.emd.gds.mapper.acosrq_v8_1.AcosRqMapToEMD_AirlineChangeOfStatusRQv08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.airlinedisplayrq_2010_2tov8_1.AirlineDisplayRqMapToEDI;
import net.hp.tr.purchase.message.emd.gds.mapper.airlinedisplayrq_v8_1.AirlineDisplayRqMapToEMD_NeutralDisplayRQv08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.displayrq_2010_2tov8_1.DisplayRqMapToTKTREQ_v08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.displayrs_v8_1.DisplayRsMapToTKTRES_v08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.displayrs_v8_1to_2010_2.DisplayRsMapToEMD_NeutralDisplayRS_v2010_2;
import net.hp.tr.purchase.message.emd.gds.mapper.exchangereissuerq_2010_2tov8_1.ExchangeReissueRQMapToTKTREQ_v08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.exchangereissuers_v8_1to2010_2.ExchangeReissueRsMapToEMD_NeutralExchangeReissueRS_v2010_2;
import net.hp.tr.purchase.message.emd.gds.mapper.exchangereissuers_v8_1to2010_2.ExchangeReissueRsMapToEMD_NeutralExchangeReissueRSv08_1_For_Null_Elements;
import net.hp.tr.purchase.message.emd.gds.mapper.historydisplayrq_2010_2tov8_1.HistoryDisplayRqMapToTKTREQ_08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.historydisplayrs_v8_1to_2010_2.HistoryDisplayRsMapToEMD_NeutralHistoryDisplayRS_v2010_2;
import net.hp.tr.purchase.message.emd.gds.mapper.issuerq_2010_2tov8_1.IssueRQMapToTKTREQ_08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.issuers_v8_1to2010_2.IssueRsMapToEMD_NeutralIssueRS_v2010_2;
import net.hp.tr.purchase.message.emd.gds.mapper.refundrq_2010_2tov8_1.RefundRqMapToTKTREQ_v08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.refundrs_v8_1to2010_2.RefundRsMapToEMD_NeutralRefundRS_2010_2;
import net.hp.tr.purchase.message.emd.gds.mapper.systemcancelrq_2010_2tov8_1.SystemCancelRQMapToTKTREQ_08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.systemcancelrs_v8_1to_2010_2.SytemCancelRsMapToEMD_NeutralSystemCancelRSv2012_2;
import net.hp.tr.purchase.message.emd.gds.mapper.voidrq_2010_2tov8_1.VoidRqMapToTKTREQ_08_1;
import net.hp.tr.purchase.message.emd.gds.mapper.voidrs_v8_1to2010_2.VoidRsMapToEMD_NeutralVoidRS_v2010_2;

public class MapForceTest {

	public static void main(String[] args) {
		
		//AcosRqMapToEMD_AirlineChangeOfStatusRQv08_1 acosRqMapToEMD_AirlineChangeOfStatusRQv08_1;
		//AcosRsMapToXML acosRsMapToXML = new AcosRsMapToXML();
		//AirlineDisplayTicketRsMapToEMD_TicketAirlineDisplayRS airlineDisplayTicketRsMapToEMD_TicketAirlineDisplayRS = new AirlineDisplayTicketRsMapToEMD_TicketAirlineDisplayRS();
		//RequestAirportcontrolRsMapToXML requestAirportcontrolRsMapToXML = new RequestAirportcontrolRsMapToXML();
		//SystemUpdateRsMapToXML systemUpdateRsMapToXML = new SystemUpdateRsMapToXML();
		//AirlineDisplayRsMapToXML airlineDisplayRsMapToXML = new AirlineDisplayRsMapToXML();
		
		//AcosRqMapToTKCREQ acosRqMapToTKCREQ = new AcosRqMapToTKCREQ();
		//AirlineDisplayRqMapToEMD_NeutralDisplayRQv08_1 airlineDisplayRqMapToEMD_NeutralDisplayRQv08_1 = new AirlineDisplayRqMapToEMD_NeutralDisplayRQv08_1();
		
		/**
		 * CTW
		 */
		
		//SystemCancelRQMapToTKTREQ_08_1 sysCancelXml2Edi = new SystemCancelRQMapToTKTREQ_08_1();
		//SytemCancelRsMapToEMD_NeutralSystemCancelRSv2012_2 sysCancelEdi2Xml = new SytemCancelRsMapToEMD_NeutralSystemCancelRSv2012_2();
		
		//VoidRqMapToTKTREQ_08_1 voidRqXml2Edi = new VoidRqMapToTKTREQ_08_1();
		//VoidRsMapToEMD_NeutralVoidRS_v2010_2 voidRsEdi2Xml = new VoidRsMapToEMD_NeutralVoidRS_v2010_2();
		
		
        try
        {
        	/*String input = "C:\\Users\\arunasom\\Desktop\\input.txt";
        	String output = "C:\\Users\\arunasom\\Desktop\\output.txt";
        	new	DisplayRsMapToTKTRES_v08_1().run(input,output);*/
        	
        	String input1 = "C:\\Users\\arunasom\\Desktop\\input1.txt";
        	String output1 = "C:\\Users\\arunasom\\Desktop\\output1.txt";
        	new	DisplayRsMapToTKTRES_v08_1().run(input1,output1);
        	
        	/*StringInput input = new StringInput("UNB+IATA:1+Z20TK+1A+010415:1243+02111452226108'UNH+1+TKTRES:08:1:IA'MSG+:798+3'ORG+1A:MUC+99999999:199082+KUL+LX+T+US:USD:EN+A0001AASU'TAI+7906+AA/SU:B'TIF+1:A+1'MON+B:75.00:USD+T:75.00:USD'FOP+CA:3:.00'PTK+A++230418+++:GB'ODI+KHH+KUL'EQN+1:TF'IFT+4:15:0'IFT+4:733:9'IFT+4:39+MEXICO MX+SWISS INTERNATIONAL'PTS+++++D'TKT+5361813623045:Y:1:2'CPN+1:E::: 7900000012980'UNT+17+1'UNZ+1+02111452226108'");
        	StringOutput output = new StringOutput();
        	
        	StringOutput airlineDisplayOutput = new StringOutput();
        	//new AirlineDisplayRsMapToXML().run(input, output);
        	new ExchangeReissueRsMapToEMD_NeutralExchangeReissueRS_v2010_2().run(input, airlineDisplayOutput);
        	String intermediateOutput = airlineDisplayOutput.getString().toString();
        	System.out.println(intermediateOutput);
        	new ExchangeReissueRsMapToEMD_NeutralExchangeReissueRSv08_1_For_Null_Elements().run(new StringInput(intermediateOutput), output);
        	System.out.println(output.getString().toString());*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Exchange-XML-RQ.xml";
        	
        	new ExchangeReissueRQMapToTKTREQ_v08_1().run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Issue-EDI-RS-Happy.txt";
        	
        	new IssueRsMapToEMD_NeutralIssueRS_v2010_2().run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Issue-XML-RQ-Happy.xml";
        	
        	new IssueRQMapToTKTREQ_08_1().run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Refund-EDI-RS.txt";
        	
        	new RefundRsMapToEMD_NeutralRefundRS_2010_2().run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Refund-XML-RQ.xml";
        	
        	new RefundRQMapToTKTREQ_v08_1().run(input, output);*/
        	
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\History-Display-EDI-RS.txt";
        	
        	new HistoryDisplayRsMapToEMD_NeutralHistoryDisplayRS_v2010_2().run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\History-Display-XML-RQ.xml";
        	
        	new HistoryDisplayRqMapToTKTREQ_08_1().run(input, output);*/
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Display-EDI-RS.txt";
        	
        	new DisplayRsMapToEMD_NeutralDisplayRS_v2010_2().run(input, output);*/
        	
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Display-XML-RQ.xml";
        	
        	new DisplayRqMapToTKTREQ_v08_1().run(input, output);*/

        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Void-EDI-RS.txt";
        	        	
        	voidRsEdi2Xml.run(input, output);*/
        	
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\Void-XML-RQ.xml";
        	
        	voidRqXml2Edi.run(input, output);*/
        	
        	//System cancel 800
        	/*String input = "C:\\Users\\arunasom\\Documents\\CTW-TestCases\\SystemCancel-EDI-RS.txt";
        	
        	sysCancelEdi2Xml.run(input, output);*/
        	
        	//sysCancelXml2Edi.run(input, output);
        	
        	
        	//ACOS - 793
        	/*String input = "C:\\Users\\arunacso\\Desktop\\793-Acos\\Acos_Santhosh.xml";
        	String output = "C:\\Users\\arunacso\\Desktop\\793-Acos\\AcosRs.txt";*/
            /*acosRqMapToEMD_AirlineChangeOfStatusRQv08_1 = new AcosRqMapToEMD_AirlineChangeOfStatusRQv08_1();
        	acosRqMapToEMD_AirlineChangeOfStatusRQv08_1.run(input, output);*/
        	
        	//acosRqMapToTKCREQ.run(input, output);
        	
        	
        	//airlineDisplayRqMapToEMD_NeutralDisplayRQv08_1.run(input, output);

        	//new AirlineDisplayRqMapToEDI().run(input, output);
        	
        	/*String input = "C:\\Users\\arunacso\\Desktop\\ErrorTest.txt";
        	String output = "C:\\Users\\arunacso\\Desktop\\ErrorTest.xml";*/
        	//acosRsMapToXML.run(input, output);
        	//airlineDisplayTicketRsMapToEMD_TicketAirlineDisplayRS.run(input, output);
        	//requestAirportcontrolRsMapToXML.run(input, output);
        	//systemUpdateRsMapToXML.run(input, output);
        	//airlineDisplayRsMapToXML.run(input, output);
        	
        	/*StringInput input = new StringInput("UNB+IATA:1+Z20TK+1A+010415:1243+02111452226108'UNH+1+TKCRES:08:1:IA'MSG+:791+7'ERC+118:Er'UNT+4+1'UNZ+1+02111452226108'");
        	StringOutput output = new StringOutput();
        	
        	StringOutput airlineDisplayOutput = new StringOutput();
        	//new AirlineDisplayRsMapToXML().run(input, output);
        	new AirlineDisplayRsMapToXML().run(input, airlineDisplayOutput);
        	String intermediateOutput = airlineDisplayOutput.getString().toString();
        	System.out.println(intermediateOutput);
        	new AirlineDisplayRsMapToEMD_NeutralDisplayRSv08_1_For_Status().run(new StringInput(intermediateOutput), output);
        	System.out.println(output.getString().toString());*/
        	//17_794-AirlineSystemUpdate
        	/*String input = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\17_794-AirlineSystemUpdate\\AirlineSystemUpdateRQ.xml";
        	String output = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\17_794-AirlineSystemUpdate\\AirlineSystemUpdateRS.txt";
        	new SystemUpdateRqMapToEDI().run(input, output);*/
        	
        	//791-Neutral Display
        	/*String input = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\791-NeutralDisplay\\NeutralDisplayRq.xml";
        	String output = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\791-NeutralDisplay\\NeutralDisplayRs.txt";
        	new AirlineDisplayRqMapToEDI().run(input, output);*/
        	
        	//131- Airline Display ticket
        	/*String input = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\131-AirlineDisplayTicket\\ticket display outgoing rq_131 - newSchema.xml";
        	String output = "C:\\Users\\arunacso\\Desktop\\Mapping Samples\\131-AirlineDisplayTicket\\ticket display outgoing rq_131 - newSchema.txt";*/
        	//new AirlineDisplayRqMapToEDI().run(input, output);
        	
        	/*String input = "C:\\Users\\arunacso\\Desktop\\authorization_mfd_input.txt";
        	String output = "C:\\Users\\arunacso\\Desktop\\authorization_mfd_output.txt";
        	new .run(input, output);*/
        	
        	/*String finalOutput[] = {"1G","UA","796","GB","91230016","08","1","  "};
        	
        	//ISO Country code fix
            if(null!=finalOutput[7] && (finalOutput[2].equalsIgnoreCase("796") || finalOutput[2].equalsIgnoreCase("798")))
            {
            	System.out.println("If part");
            }
            else
            {
            	System.out.println("Else part");	
            }*/

        } catch (Exception e)
        {
            e.printStackTrace();
        }
	}

}
