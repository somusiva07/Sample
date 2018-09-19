package com.sample;

public class ERCSegmentTest {

	public static void main(String[] args) {
		
		/*String message[] = {"UNB+IATAA:4+Sender+Recipient+171204:0301+02111452226108+7' UNH+0+TKTRES:08:1:IA' MSG+:791+7' ERC+118' UNT+4+0' UNZ+1+02111452226108",   
		"UNB+IATA:1+BEEMD+1SEMD+171203:2231+08GH0D780F0001' UNH+4156+TKTRES:08:1:IA+C23BE9C1D78F' MSG+:800::796+7' ERC+911' UNT+4+4156' UNZ+1+08GH0D780F0001'",   
		"UNB+IATAA:4+Sender+Recipient+171204:0444+02111452226108' UNH+0+TKTRES:08:1:IA' MSG+:791+7' ERC+14' UNT+4+0' UNZ+1+02111452226108'",  
		"UNB+IATAA:4+Sender+Recipient+171204:0003+02111452226108' UNH+0+TKTRES:08:1:IA' MSG+:791+7' ERC+3' UNT+4+0' UNZ+1+02111452226108'",  
		"UNB+IATA:1+UA+1B+171204:0003+FFF6574B910001' UNH+4333+TKTRES:08:1:IA+330BF6C1AE97' MSG+:17+7' ERC+368' UNT+4+4333' UNZ+1+FFF6574B910001'",  
		"UNB+IATA:1+UA+1G+171204:0912+91272882' UNH+1+TKTRES:08:1:IA' MSG+:791+7' ERC+401' UNT+4+1' UNZ+1+91272882'",  
		"UNB+IATA:1+UA+1S+171204:0707+FFD7426E920001' UNH+5081+TKTRES:08:1:IA+4562DBC184DD' MSG+:796+7' ERC+912' UNT+4+5081' UNZ+1+FFD7426E920001'",   
		"UNH+3704+TKTRES:08:1:IA+773A8FC1DC70' MSG+:791+3' ORG+1S+23279001:2NYC+MUC++T+DE:EUR+AW1' TIF+MUELLER:A+MARWIN MR' TAI+0011+AW2:B' RCI+1S:PII_MASKED:1+BE:DDVVWS:1' MON+B:35.00:EUR+T:35.00:EUR' FOP+MS:3:35.00::::::::::INV' PTK+N::I::::NE:NR++241117+++:DE' EQN+1:TF' IFT+4:10+NON-REFUNDABLE/NON-EXCHANGEABLE' IFT+4:15:0' IFT+4:733:0' IFT+4:39+MUENCHEN       DE+FTI TICKETSHOP GM' PTS+++++C' TKT+2672905271810:J:1:3' CPN+1:V:35.00:: 1530000003525' TVL+011217:0000:011217:0000+BHX+HAJ+BE++K' PTS+++++C+0C3' EBD++1::N' IFT+4:47+23KG BAG' TKT+2672905271810:J:1:4::2675745952364' CPN+1::35:::::2::703' UNT+24+3704' UNZ+1+08B81DC7000001'",   
		"UNB+IATAA:4+Sender+Recipient+171204:0028+02111452226108' UNH+0+TKTRES:08:1:IA+7' MSG+:796+3' ERC+118' TKT+2302716561553' UNT+4+0' UNZ+1+02111452226108'   ",
		"UNB+IATAA:4+Sender+Recipient+171204:0301+02111452226108' UNH+0+TKTRES:08:1:IA' MSG+:803+3' CPN+:::: 7900000002930' IFT+1:7' TKT+0163010041443:::3' UNT+6+0' UNZ+1+02111452226108'",
		"UNB+IATA:1+BEEMD+1SEMD+171203:2233+08GH0D79010001' UNH+4159+TKTRES:08:1:IA+C23BE9C1D791' MSG+:17::796+7' TKT+2672905363850' UNT+4+4159' UNZ+1+08GH0D79010001'",
		"UNB+IATA:1+BEEMD+1SEMD+171203:2233+08GH0D79010001' UNH+4159+TKTRES:08:1:IA+C23BE9C1D791' MSG+:17::79+7' TKT+2672905363850' UNT+4+4159' UNZ+1+08GH0D79010001'"};

		for(String msg : message)
		{
			//if(msg.matches(".*MSG+.*\\+7'.*") && msg.matches(".*ERC+.*"))
			if(msg.matches(".*MSG\\+\\:(\\d{2}|\\d{3}|\\d{2}::\\d{2}|\\d{2}::\\d{3}|\\d{3}::\\d{2}|\\d{3}::\\d{3})\\+7\\'.*")) 
	    	{
				if(msg.matches(".*[ERC]\\+(\\d{1}|\\d{2}|d{3}\\').*"))
				{
					System.out.println(msg.substring(msg.indexOf("ERC")+4,msg.indexOf("ERC")+7));
				}
				else
				{
					System.out.println("ERC Segment not available");
				}
	    	}
			else
			{
				System.out.println("NOT matched for "+msg);
			}
		}*/
		
		String msg = "UNB+IATAA:4+Sender+Recipient+171123:0745+02111452226108'UNH+0+TKCRES:08:1:IA'MSG+:794+7'ERC+401'UNT+4+0'UNZ+1+02111452226108'";
		//String msg = "UNB+IATA:1+CM+UA+180117:1212+007541'UNH+1+TKCRES:08:1:IA+UA7541'MSG+:791+7'ERC+107'UNT+4+0'UNZ+1+007541'";
    	
		int indexFirst = msg.indexOf("ERC");
		String erc = msg.substring(indexFirst);
		System.out.println(erc);
		int plusFirst = erc.indexOf("+");
		int aposFirst = erc.indexOf("'");
		System.out.println(erc.substring(plusFirst+1,aposFirst));
		String errorMsg = "Test Msg"; 
        int secondIndex = 96;
        
        System.out.println(msg.replace(msg.substring(secondIndex-1), new String().concat(":").concat(errorMsg).concat(msg.substring(secondIndex-1))));
       
	}

}
