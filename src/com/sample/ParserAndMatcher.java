package com.sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserAndMatcher {

	public static final String HTTP_REGEX = "((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s\"]*))";
	
	public static final String ALPHANUMERIC_REGEX = "((?:[a-z][a-z0-9_]*))";
	
	public static final String EMPTY_STRING = "";
	
	public static void main(String[] args) {
		/*String body = "<web:ping xmlns:web=\"http://webservice.interline.gds.emd.message.purchase.tr.hp.net/\" xmlns:air=\"http://emd.airservices.svcs.entsvcs.net/tr/purchase/emd/orchestration/2017/05/AirlinePingRQ\" xmlns:iata=\"http://www.iata.org/IATA/2007/00/IATA_CommonTypes\">\r\n         <!--Optional:-->\r\n         <AirlinePingRQ AltLangID=\"PN\" CorrelationID=\"1234\" EchoToken=\"AA\" PrimaryLangID=\"EN\" Target=\"PROD\" Version=\"8.1\">\r\n            \r\n            <air:POS xmlns:air=\"http://emd.airservices.svcs.entsvcs.net/tr/purchase/emd/orchestration/2017/05/AirlinePingRQ\">\r\n               \r\n               <iata:Source AgentSine=\"AS3303\" ISOCountry=\"CH\" PseudoCityCode=\"ZRH\" xmlns:iata=\"http://www.iata.org/IATA/2007/00/IATA_CommonTypes\">\r\n               </iata:Source>\r\n            </air:POS>\r\n            \r\n            <air:CustomerDataList xmlns:air=\"http://emd.airservices.svcs.entsvcs.net/tr/purchase/emd/orchestration/2017/05/AirlinePingRQ\">\r\n               \r\n               <air:CustomerData>\r\n                  <air:Name>SANTOSH</air:Name>\r\n                  <air:Value>DASH</air:Value>\r\n               </air:CustomerData>\r\n            </air:CustomerDataList>\r\n            \r\n         </AirlinePingRQ>";
        
        String namespaces = body.substring(body.indexOf("xmlns"), body.indexOf('>'));
        
        String[] tagIdentifiers = {"<AirlinePingRQ","</AirlinePingRQ>"};
            
        Pattern startPattern = Pattern.compile(tagIdentifiers[0]);
        Pattern endPattern = Pattern.compile(tagIdentifiers[1]);
        Matcher matcher = startPattern.matcher(body);
        int startIndex = -1;
        int endIndex = -1;
        if (matcher.find())
        {
            startIndex = matcher.start();
            matcher = endPattern.matcher(body);
            if (matcher.find())
            {
                endIndex = matcher.end();
            }
        }
        System.out.println("Start : "+startIndex);
        System.out.println("End : "+endIndex);
        body = body.substring(startIndex, endIndex);
        String httpUrlWithQuotesRegex = "(\")" + HTTP_REGEX + "(\")";
        // Replace Strings such as the example types, xmlns:web="http://www.abc.com/xyz" and
        // xmlns="http://www.abc.com/xyz" with empty Strings.
        String bodyWithoutNamespaces =
            body.replaceAll("(xmlns:)" + ALPHANUMERIC_REGEX + "(=)" + httpUrlWithQuotesRegex,
                    EMPTY_STRING).replaceAll("(xmlns=)" + httpUrlWithQuotesRegex,
                    EMPTY_STRING);
        // Now append one common namespace string to the root element for the entire XML.
        String bodyWithNamespaces = bodyWithoutNamespaces.replaceFirst("(>)", " " + namespaces + ">");
        
        System.out.println(bodyWithNamespaces);*/
		
		
		String body = "<air:POS >\r\n        <iata:Source AgentSine=\"AS3303\" ISOCountry=\"CH\" PseudoCityCode=\"ZRH\" >\r\n        </iata:Source>\r\n </air:POS>\r\n <air:CustomerDataList >\r\n         <air:CustomerData>\r\n           <air:Name>SANTOSH</air:Name>\r\n           <air:Value>DASH</air:Value>\r\n        </air:CustomerData>\r\n </air:CustomerDataList>";
		
		String[] tagIdentifiers = {"<air:POS","</air:POS>"};
        
        Pattern startPattern = Pattern.compile(tagIdentifiers[0]);
        Pattern endPattern = Pattern.compile(tagIdentifiers[1]);
        Matcher matcher = startPattern.matcher(body);
        int startIndex = -1;
        int endIndex = -1;
        if (matcher.find())
        {
            startIndex = matcher.start();
            matcher = endPattern.matcher(body);
            if (matcher.find())
            {
                endIndex = matcher.end();
            }
        }
        System.out.println("Start : "+startIndex);
        System.out.println("End : "+endIndex);
        body = body.substring(startIndex, endIndex);

        System.out.println(body);
        
	}

}
