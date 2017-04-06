package com.gjw.test.service;

import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import com.gjw.test.http.TransSubmit;
import com.gjw.test.util.HttpUtile;

public class HttpService {
	
	private static Logger logger = Logger.getLogger(HttpService.class.getName());
	
	public static String sendReq(String hostAddr,String params,String httpHeaderParam)
	{
		HttpPost httpPost = new HttpPost(hostAddr);
		Map<String, String> paramMap = HttpUtile.getParamMap(params);
		Map<String, String> httpHeaderMap = HttpUtile.getParamMap(httpHeaderParam);
		reqHeaderAddParam(httpPost, httpHeaderMap);
		logger.info("请求发送数据："+params+"，请求头数据："+httpHeaderParam+"，请求地址："+hostAddr);
		String result = TransSubmit.doPost(httpPost, paramMap);
		logger.info("请求返回数据："+result);
		return result;
	}
	/**
	 * 给http请求头添加信息
	 * @param paramMap
	 */
	public static void reqHeaderAddParam(HttpPost httpPost,Map<String, String> httpHeaderMap)
	{
		for (Map.Entry<String, String> entry : httpHeaderMap.entrySet()) {  
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}  
	}
}
