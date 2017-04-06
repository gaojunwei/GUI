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
		logger.info("登录接口请求发送数据："+username);
		String result = TransSubmit.doPost(httpPost, paramMap);
		logger.info("登录接口请求返回数据："+result);
		return result;
	}
}
