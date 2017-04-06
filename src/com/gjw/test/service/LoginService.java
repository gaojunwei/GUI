package com.gjw.test.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.log4j.Logger;

import com.gjw.test.http.TransSubmit;

public class LoginService {
	
	private static Logger logger = Logger.getLogger(LoginService.class.getName());
	
	public static String sendReq(String login_addr_str,String username,String pwd)
	{
		HttpPost httpPost = new HttpPost(login_addr_str);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("loginid", username);
		paramMap.put("password", pwd);
		logger.info("��¼�ӿ����������ݣ�"+username);
		String result = TransSubmit.doPost(httpPost, paramMap);
		logger.info("��¼�ӿ����󷵻����ݣ�"+result);
		return result;
	}
}
