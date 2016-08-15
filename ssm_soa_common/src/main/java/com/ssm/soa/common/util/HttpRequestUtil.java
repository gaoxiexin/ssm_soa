package com.ssm.soa.common.util;

/** 
 * 文件说明 * @Description:扩展说明 
 * @Copyright: 2015 dreamtech.com.cn Inc. All right reserved 
 * @Version: V6.0 
*/

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpRequestUtil {
	
	private static String messageUrl = "http://211.147.239.62:9050/cgi-bin/sendsms/";

	public static String postRequest(String url, Map<String, Object> params) {
		// 构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		// 创建POST方法的实例
		PostMethod postMethod = new PostMethod(url);
		// 设置请求头信息
		postMethod.addRequestHeader("Content-Type",  
                "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码  
//		// 添加参数
//		for (Map.Entry<String, Object> entry : params.entrySet()) {
//			postMethod.addParameter(entry.getKey(),
//					String.valueOf(entry.getValue()));
//		}
		// 使用系统提供的默认的恢复策略,设置请求重试处理，用的是默认的重试处理：请求三次
		httpClient.getParams().setBooleanParameter(
				"http.protocol.expect-continue", false);
		
		 NameValuePair[] data = { new NameValuePair("username", "tianshili02@tianshili"), // 注册的用户名  
	                new NameValuePair("password", "23!xwwx8"), // 注册成功后,登录网站使用的密钥  
	                new NameValuePair("to", "18222601949"), // 手机号码  
	                new NameValuePair("text", "以后给我老实点哈。。。。听话。。。"),
	                new NameValuePair("msgtype", "1")};//设置短信内容          

		 postMethod.setRequestBody(data);  
		// 接收处理结果
		String result = null;
		try {
			// 执行Http Post请求
			httpClient.executeMethod(postMethod);
			// 返回处理结果
			result = postMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题 System.out.println(请检查输入的URL!);
			e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常System.out.println(发生网络异常!);
			e.printStackTrace();
		} finally {
			// 释放链接
			postMethod.releaseConnection();
			// 关闭HttpClient实例
			if (httpClient != null) {
				((SimpleHttpConnectionManager) httpClient
						.getHttpConnectionManager()).shutdown();
				httpClient = null;
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("username", "tianshili02@tianshili");
		params.put("password", "23!xwwx8");
		params.put("msgtype", "1");
		params.put("to", "18222601949");
		params.put("text", "测试数据");
		
		System.out.println("发送短信结果："+HttpRequestUtil.postRequest(messageUrl, params));
	}
}