package webservice;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class DomDemo1 {

	public static void main(String[] args) throws DocumentException {

		String xmlString = "<user><name>caipch</name></user>";
		Document document = DocumentHelper.parseText(xmlString);
		System.out.println(document.asXML());
	}

}
