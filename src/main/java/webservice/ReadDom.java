package webservice;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 读取language.xml
 * @author caipch
 * @date 2019年1月15日
 */
public class ReadDom {

	public static void main(String[] args) {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("language.xml"));
			
			//1.获取根节点
			Element root = document.getDocumentElement();
			System.out.println(root.getNodeName());
			
			//2.获取第二层子节点列表
			NodeList langlist = root.getElementsByTagName("Language");
			
			//3.遍历输出第二层子节点
			for (int i = 0; i < langlist.getLength(); i++) {
				Element lanele = (Element) langlist.item(i);
				System.out.println("-------------------------");
				System.out.println("Language id:"+lanele.getAttribute("id"));
				
				//4.继续获取子节点列表
				NodeList childlist = lanele.getChildNodes();
				for(int j = 0;j < childlist.getLength();j++) {
					Node childnode = childlist.item(j);
					//空格也属于node，要判断是否为element
					if (childnode instanceof Element) {
						System.out.println(childnode.getNodeName()+":"+childnode.getTextContent());
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
