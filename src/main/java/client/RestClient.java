package client;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * webservice获得国外国家名称和与之对应的ID
 * @author caipch
 * @date 2019年1月24日
 */
public class RestClient {

	public static void main(String[] args) {
		String uri = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getRegionCountry";
		
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(uri);
		try {
			HttpResponse response = httpClient.execute(httppost);
			System.out.println("-------------");
			
			String result = EntityUtils.toString(response.getEntity());
			
			Document resdocument =  DocumentHelper.parseText(result);
			Element root = resdocument.getRootElement();
			root.elements();
			
			List<Element> list = root.elements("string");
			for (Element element : list) {
				System.out.println(element.getData());
			}
//			System.out.println(root);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
