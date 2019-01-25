package client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;

/**
 * rest接口调用方法二：
 * HttpClient
 * @author caipch
 * @date 2019年1月15日
 */
public class ServiceDemoClient2 {

	public static void main(String[] args) {
		
		try {
			String url = "http://localhost:8080/restservice/";
			//1.新建一个httpclient对象
			HttpClient httpClient = HttpClients.createDefault();
			//2.发送get请求，创建httpget对象
			HttpUriRequest request = new HttpGet(url);
			//3.设置参数
			//4.发起请求，获取response
			System.out.println(httpClient.execute(request).getHeaders("title"));
			System.out.println(httpClient.execute(request).getEntity().toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
