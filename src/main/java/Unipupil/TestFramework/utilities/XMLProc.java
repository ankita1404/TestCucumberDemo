/* Test script to buy a course with additional fees
 * Script logs in as institution, selects a course and records the course title, basic fee and additional fee.
 * It then logs in as a student and selects the same course and adds it to the cart.  The information displayed
 * in the cart, the checkout page, the order review page, the Paypal minibasket, the order status page and the 
 * student account page are checked against the information pulled during the institution login.  The script also
 * checks that line totals match order totals and subtotals and that information in a given view is consistent
 * with that visible in a previous view.
 * 
 * @author Joseph Lalor
 * 
 */

package Unipupil.TestFramework.utilities;

import java.math.BigDecimal;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLProc 
{
	//private static Logger logger = LoggerFactory.getLogger(XMLProc.class);
	// Variables
	String programClassName = "XMLProc";
	Document doc;
	String value;
	String filepath;
	
	public XMLProc(){
		System.out.println(programClassName+" default constructor");
	}
	
	public XMLProc(String filepath){
		System.out.println(programClassName+" constructor");
		this.filepath = filepath;
	}
	
	public Document getDocument(){
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		    doc = docBuilder.parse(filepath);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		return doc;
	}
	
	public String getValue(Document doc, String tagName) {
		System.out.println(programClassName+": 'getValue' running");
		//logger.info(programClassName+": 'getValue' running");
		String value="";
		try{
		    doc.getDocumentElement().normalize();
		    System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		    NodeList nodeList = doc.getElementsByTagName(tagName);
		    for (int index = 0; index < nodeList.getLength(); index++) {
			    Node node = nodeList.item(index);
			    System.out.println("\nCurrent Element: " + node.getNodeName());
			    if (node.getNodeType() == Node.ELEMENT_NODE) {
				    Element element = (Element) node;
				    value = element.getTextContent();
				    System.out.println(tagName + " " + value);
				    break;
			    }
		    }
	    }
		catch (Exception exception) {
		    exception.printStackTrace();
	    }
		return  value;
	}
	
	public void setValue(Document doc, String tagName, String val)
	{
        System.out.println(programClassName+": 'setValue' running");
        //logger.info(programClassName+": 'setValue' running");
        try{
        	NodeList nodeList = doc.getElementsByTagName(tagName);
        	for (int index = 0; index < nodeList.getLength(); index++) {
			    Node node = nodeList.item(index);
			    System.out.println("\nCurrent Element: " + node.getNodeName());
			    if (tagName.equals(node.getNodeName())) {
				    node.setTextContent(val);
				    System.out.println(tagName + " " + val);
				    break;
			    }
		    }
        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    		Transformer transformer = transformerFactory.newTransformer();
    		DOMSource source = new DOMSource(doc);
    		StreamResult result = new StreamResult(new File(filepath));
    		transformer.transform(source, result);
        	
        }
        catch (TransformerException tfe) {
    		tfe.printStackTrace();
    	} 
        catch(Exception exception) {
        	exception.printStackTrace();
        }
 	}
	

}