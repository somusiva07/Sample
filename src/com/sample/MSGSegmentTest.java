package com.sample;

import java.util.HashMap;
import java.util.Map;

public class MSGSegmentTest {

	/**
     * TIF Segment Identifier
     */
    public static final String TIF_SEGMENT_INDENTIFIER = "TIF";
    
    /**
     * Composite separator for EDIFACT message.
     */
    public static final String COMPOSITE_SEPARATOR = ":";
    /**
     * EDIFACT segment terminator.
     */
    public static final String SEGMENT_TERMINATOR = "'";
    
	public static final String DATA_ELEMENT_SEPARATOR = "+";
	
	/**
     * Identifier for detecting the start of UNB segment.
     */
    public static final String UNB_SEGMENT_IDENTIFIER = "UNB";
    /**
     * Identifier for detecting the start of UNH segment.
     */
    public static final String UNH_SEGMENT_IDENTIFIER = "UNH";
    /**
     * Identifier for detecting the start of UNBT segment.
     */
    public static final String UNT_SEGMENT_IDENTIFIER = "UNT";
    /**
     * Identifier for detecting the start of UNZ segment.
     */
    public static final String UNZ_SEGMENT_IDENTIFIER = "UNZ";
    /**
     * Identifier for detecting the start of ORG segment.
     */
    public static final String ORG_SEGMENT_IDENTIFIER = "ORG";
    /**
     * Identifier for detecting the start of MSG segment.
     */
    public static final String MSG_SEGMENT_IDENTIFIER = "MSG";
    /**
     * Identifier for detecting the start of PTK segment.
     */
    public static final String PTK_SEGMENT_IDENTIFIER = "PTK";
    /**
     * Identifier for detecting the start of TKT segment.
     */
    public static final String TKT_SEGMENT_IDENTIFIER = "TKT";
    /**
     * Identifier for detecting the start of ERC segment.
     */
    public static final String ERC_SEGMENT_IDENTIFIER = "ERC";

	private static final String ISSUE_STRING = "796";

	private static final String EXCHANGE_STRING = "798";
    
	/*public static void main(String[] args) {
		
		String message[] = {"UNB+IATAA:4+Sender+Recipient+171204:0301+02111452226108+7' UNH+0+TKTRES:08:1:IA' MSG+:791+7' ERC+118' UNT+4+0' UNZ+1+02111452226108",   
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
			if(msg.matches(".*MSG\\+\\:(\\d{3}|\\d{3}::\\d{2}|\\d{3}::\\d{3}).*")) 
	    	{
				
					System.out.println(msg.substring(msg.indexOf("MSG")+5,msg.indexOf("MSG")+8));
				
	    	}
			
			if(msg.matches(".*MSG\\+\\:(\\d{2}|\\d{2}::\\d{2}|\\d{2}::\\d{3}).*")) 
	    	{
				
					System.out.println(msg.substring(msg.indexOf("MSG")+5,msg.indexOf("MSG")+7));
				
	    	}
			else
			{
				System.out.println("NOT matched for "+msg);
			}
		}
		
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("H","Hai");
		params.put("Ha","Hello");
		params.put("Hai",null);
		
		if(isNullOrEmpty(params.get("Hai")))
			System.out.println("Null map value is  "+params.get("Hai"));
		else
			System.out.println("Something wrong in Null map ");
    	
	}

	private static final String EMPTY_STRING = "";
	
	public static boolean isNullOrEmpty(String value)
    {
        return value == null || EMPTY_STRING.equals(value);
    }*/
	
	
    /**
     * Added by <b>Kant,Shashi</b>.<br/>
     * 
     * Will extract mandatory segments and match them against respective regular expression defined.
     * 
     * @param message
     *            String from which segment need to be extracted.
     * @param segment
     *            String representing segment name to be used for extracting the segment.
     * @return
     * @throws HeaderTranslatorServiceException
     */
    public String extractSegment(String message, String segment) throws Exception
    {
        try
        {
        	if(PTK_SEGMENT_IDENTIFIER.equalsIgnoreCase(segment))
        	{
        		int begin = message.indexOf(SEGMENT_TERMINATOR + TIF_SEGMENT_INDENTIFIER + DATA_ELEMENT_SEPARATOR);
        		int end = message.indexOf(SEGMENT_TERMINATOR + TKT_SEGMENT_IDENTIFIER + DATA_ELEMENT_SEPARATOR);
        		message = message.substring(begin,end);
        	}
        	
            // String substringMessage = "";
            int beginIndex = 0;
            if (message.indexOf(segment) == 0)
            {
                beginIndex = 0;
            } else
            {
                beginIndex = message.indexOf(segment + DATA_ELEMENT_SEPARATOR);
            }

            String substringMessage = message.substring(beginIndex);
            return substringMessage.substring(0, substringMessage.indexOf('\'') + 1);
           
        } catch (Exception e)
        {
            throw new Exception("Problem extracting the Mandatory Header Segments : " + segment,
                    e);
        }
    }
    
    /**
     * Build segments based on message type. ISO country code Fix for 796 and 798 
     * @param message
     * @return String message 
     * @throws HeaderTranslatorServiceException
     */
    private String buildSegmentsByMessageTypes(String message) throws Exception
    {
    	String messageType = new String();
    	String messageToBeReturned = new String();
    	if(message.matches(".*MSG\\+\\:(\\d{3}'|\\d{3}::\\d{2}'|\\d{3}::\\d{3}').*")) 
    	{
			
    		messageType = message.substring(message.indexOf("MSG")+5,message.indexOf("MSG")+8);
			
    	}
		
		if(message.matches(".*MSG\\+\\:(\\d{2}'|\\d{2}::\\d{2}'|\\d{2}::\\d{3}').*")) 
    	{
			
			messageType = message.substring(message.indexOf("MSG")+5,message.indexOf("MSG")+7);
			
    	}
		
		if(null!=messageType && messageType.equalsIgnoreCase(ISSUE_STRING) || messageType.equalsIgnoreCase(EXCHANGE_STRING))
		{
			System.out.println("If part");	
	        messageToBeReturned = messageToBeReturned + extractSegment(message, UNB_SEGMENT_IDENTIFIER)
	                    + extractSegment(message, UNH_SEGMENT_IDENTIFIER) + extractSegment(message, MSG_SEGMENT_IDENTIFIER)
	                    + extractSegment(message, ORG_SEGMENT_IDENTIFIER) + extractSegment(message, PTK_SEGMENT_IDENTIFIER)
	                    + extractSegment(message, UNT_SEGMENT_IDENTIFIER)+ extractSegment(message, UNZ_SEGMENT_IDENTIFIER);
		}
		else
		{System.out.println("Else pART");
			messageToBeReturned =
		            messageToBeReturned + extractSegment(message, UNB_SEGMENT_IDENTIFIER)
		                    + extractSegment(message, UNH_SEGMENT_IDENTIFIER) + extractSegment(message, MSG_SEGMENT_IDENTIFIER)
		                    + extractSegment(message, ORG_SEGMENT_IDENTIFIER) + extractSegment(message, UNT_SEGMENT_IDENTIFIER)
		                    + extractSegment(message, UNZ_SEGMENT_IDENTIFIER);
		}
		return messageToBeReturned;
    }
    
    public static void main(String args[]) throws Exception
    {
    	/*String message = "UNB+IATA:1+1G+UA+171208:1139+BA5D14'UNH+1+TKTREQ:08:1:IA'MSG+:796'ORG+1G:ATL+91230016:0C7C+LON+1G+T+GB+0699090'PTK+N++081217:1139+UA++:SR'TAI+7733+0C7C:B'RCI+1G:Z48V9K:1+UA:OCMD5V:1'EQN+1:TD'TIF+STEWART:A+ALEXANDERMR'MON+B:149.00:GBP+T:149.00:GBP'FOP+CA:3:149.00'PTK+N++081217:1139+UA++:PR'EQN+1:TF'IFT+4:15:1'IFT+4:39+GLASGOW+IMTGCLYDETRAVEL'IFT+4:733:1'PTS+++++D'TKT+0162903131262:Y:1:3'CPN+1:I:149.00'TVL+091217:0000+MOB++UA+++1'PTS++++++993'DAT+1:091217'IFT+4:47+REBOOKING FEE INTL'IFT+4:42+MOB'IFT+4:40+UA'PTK+N++081217:1139+UA++:BR'TKT+0162903131262:Y:1:4::0165942468051'UNT+25+1'UNZ+1+BA5D14'";
    	System.out.println(new MSGSegmentTest().buildSegmentsByMessageTypes(message));*/
    	
    	/*String desc = "ERC-401";
    	
    	int begin = desc.indexOf("-")+1;
		int end = desc.indexOf("-")+4;
		
		System.out.println(desc.substring(begin, end));*/
    	
    	/*String msg1 = "UNB+IATB:1+1APPC+UA1TK+180629:0000+02Y1S70KBB0001+++O'UNH+1+TKTREQ:08:1:IA+0006034VOK9JGY'MSG+:791'ORG+1A:MUC+49546932:061739+RIC++T+US:USD:EN+A9999WSSU'TKT+0167118804273'UNT+5+1'UNZ+1+02Y1S70KBB0001'";
    	String unh1 = new MSGSegmentTest().extractSegment(msg1, UNH_SEGMENT_IDENTIFIER);
    	System.out.println(unh1);
    	String id[] = unh1.split("\\+");
    	System.out.println(id[3].replace("'", ""));
		StringBuilder str = new StringBuilder();
		System.out.println(str.append(id[0]).append("+").append(id[1]).append("+").append(id[2]).append("+").
				append(correlationId).toString());
    	
    	
    	String msg2 = "UNB+IATB:1+1APPC+UA1TK+180629:0000+02Y1S70KBB0001+++O'UNH+1+TKTREQ:08:1:IA+0006034VOK9JGY+XX:XX'MSG+:791'ORG+1A:MUC+49546932:061739+RIC++T+US:USD:EN+A9999WSSU'TKT+0167118804273'UNT+5+1'UNZ+1+02Y1S70KBB0001'";
    	String unh2 = new MSGSegmentTest().extractSegment(msg2, UNH_SEGMENT_IDENTIFIER);
    	System.out.println(unh2);
    	String id1[] = unh2.split("\\+");
    	System.out.println(id1[3].replace("'", ""));
    	
    	String id2[] = new MSGSegmentTest().extractSegment(msg1, UNH_SEGMENT_IDENTIFIER).split("\\+");
    	System.out.println(id2[3].replace("'", ""));*/

    	
    	String correlationId = "1YUA51F7293B61C96BF55E17";
    	
    	String msg1 = "UNB+IATB:1+1APPC+UA1TK+180629:0000+02Y1S70KBB0001+++O'UNH+1+TKTREQ:08:1:IA+0006034VOK9JGY'MSG+:791'ORG+1A:MUC+49546932:061739+RIC++T+US:USD:EN+A9999WSSU'TKT+0167118804273'UNT+5+1'UNZ+1+02Y1S70KBB0001'";
    	String unh1 = new MSGSegmentTest().extractSegment(msg1, UNH_SEGMENT_IDENTIFIER);
    	//System.out.println(unh1);
    	String id[] = unh1.split("\\+");
    	StringBuilder str = new StringBuilder();
    	for(int i=0;i<id.length;i++)
    	{
    		if(i==3)
    			str.append(correlationId).append("+");
    		else
    			str.append(id[i]).append("+");	
    	}
    	String str2=str.toString().substring(0, str.length()-1);
    	if(str2.charAt(str2.length()-1)!='\'')
    		str2 = str2.concat("'");
    	System.out.println("Str : 2 : "+str2);
    	
    	String msg2 = "UNB+IATB:1+1APPC+UA1TK+180629:0000+02Y1S70KBB0001+++O'UNH+1+TKTREQ:08:1:IA+0006034VOK9JGY+XX:XX'MSG+:791'ORG+1A:MUC+49546932:061739+RIC++T+US:USD:EN+A9999WSSU'TKT+0167118804273'UNT+5+1'UNZ+1+02Y1S70KBB0001'";
    	String unh2 = new MSGSegmentTest().extractSegment(msg2, UNH_SEGMENT_IDENTIFIER);
    	//System.out.println(unh2);
    	String id1[] = unh2.split("\\+");
    	StringBuilder str1 = new StringBuilder();
    	for(int i=0;i<id1.length;i++)
    	{
    		if(i==3)
    			str1.append(correlationId).append("+");
    		else
    			str1.append(id1[i]).append("+");	
    	}
    	String str3=str1.toString().substring(0, str1.length()-1);
    	if(str3.charAt(str3.length()-1)!='\'')
    		str3 = str3.concat("'");
    	System.out.println("Str : 3 : "+str3);
    	
    }
}
