package com.gjw.test.service;

import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import com.gjw.test.http.TransSubmit;
import com.gjw.test.util.HttpUtile;
import com.gjw.test.util.Utile;

public class ReqService {
	
	private static Logger logger = Logger.getLogger(ReqService.class.getName());
	
	public static String sendReq(String hostAddr,String params)
	{
		hostAddr = Utile.getInstance().getFullUrl(hostAddr);
		HttpPost httpPost = new HttpPost(hostAddr);
		Map<String, String> paramMap = HttpUtile.getParamMap(params);
		httpPost.addHeader("authentication", Utile.TOKEN);
		logger.info("请求发送数据："+params+"，请求地址："+hostAddr);
		String result = TransSubmit.doPost(httpPost, paramMap);
		logger.info("请求返回数据："+result);
		return result;
	}
}
