package client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * 调用哪个Rest接口方法一：
 * 使用HttpURLConnection
 * @author caipch
 * @date 2019年1月15日
 */
public class ServiceDemoClient {
	public static void main(String[] args) {
		callRest("http://localhost:8080/restservice/","get");
	}

	private static void callRest(String url, String method) {
		String result = null;
		HttpURLConnection connection = null;
		try {
			//1.把url转成对象
			URL target = new URL(url);
			//2.打开链接
			connection = (HttpURLConnection) target.openConnection();
			//3.设置请求头
			connection.setRequestMethod(method.toUpperCase());
			connection.setRequestProperty("Accept", "application/json");
			if(200!=connection.getResponseCode()) {
				throw new RuntimeException("请求失败，错误代码是："+connection.getResponseCode());
			}
			System.out.println("success");
			byte[] temp = new byte[connection.getInputStream().available()];
			if(connection.getInputStream().read(temp)!=-1) {
				result = new String(temp);
			}
			System.out.println(result);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
