package com.java7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTransform {
    public static void main(String[] args) throws IOException, URISyntaxException,SAXException, ParserConfigurationException,TransformerException {            
            // Load XML and XSL Document
            String inputXML = "C://test.xml";
            //String xslFile = "C://Script.xsl";
            String outputXML = "C://Output.xml";

            //Source xslt = new StreamSource(new File(xslFile));            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();            
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(inputXML));

            removeNodes(doc);
            
            // XSLT Transformation  with pretty print
                                    

            
            
            
            
            
            
            
    }
    
    public static void removeNodes(Node node) throws ParserConfigurationException, TransformerException {
    	
    	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document d = docBuilder.newDocument();
    	
        NodeList list = node.getChildNodes();
        //System.err.println("Length is : "+list.getLength());
        for (int i = 0; i < list.getLength(); i++) {
            removeNodes(list.item(i));
        }
        boolean emptyElement = false;
        List<Node> nodeNames = new ArrayList<Node>();
        if(node.getNodeType() == Node.ELEMENT_NODE)
        {
        	
        	if(null!=node.getNodeName() && !node.getNodeName().equalsIgnoreCase("web:ping"))
        	{
        		System.err.println("ELEMENT_NODE is : "+node.getNodeName()+" : local name : "+node.getLocalName()+" : tostring : "+node.toString());
        		nodeNames.add(node);
        	}
        	
        }
        
        for(Node nod : nodeNames)
        {
        	//System.err.println("ELEMENT_NODE is : "+node.getNodeName()+" : local name : "+node.getLocalName()+" : tostring : "+node.toString());
        	//node.getParentNode().removeChild(nod);
        	//node.appendChild(nod);
        	Node newNode = d.importNode(nod, true);
        	d.appendChild(newNode);
        }
        
        if(node.getNodeName().equalsIgnoreCase("web:AirlinePingRQ"))
        {
        	TransformerFactory prettyPrint = TransformerFactory.newInstance();
            Transformer transformer = prettyPrint.newTransformer();

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            DOMSource source = new DOMSource(d);
            StringWriter writer = new StringWriter();
            //StreamResult result = new StreamResult(new File(outputXML));
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            System.out.println("Output is  :"+writer.toString());	
        }
        
        
    }
}