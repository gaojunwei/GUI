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
		logger.info("���������ݣ�"+params+"�������ַ��"+hostAddr);
		String result = TransSubmit.doPost(httpPost, paramMap);
		logger.info("���󷵻����ݣ�"+result);
		return result;
	}
}
