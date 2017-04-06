/**
 * ˵����Demo���ṩ��ǩ����ǩ�ͼ򵥵Ľӿڵ��òο�
 * ����Ŀ�������ƽ̨����ͽӿ��ĵ�Ϊ׼
 * 
 *�㸶�������޹�˾
 *
 * Copyright (c) 2006-2013 ChinaPnR,Inc.All Rights Reserved.
 */
package com.gjw.test.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class TransSubmit
{
	private static Logger logger = Logger.getLogger(TransSubmit.class.getName());
	/**
	 * �����ע����������Կ���ʹ��HttpClientConnectionManager
	 * @param hostAddr �ύ��ַ
	 * @param params �������
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String doPost(String hostAddr,Map<String, String> params) throws UnsupportedEncodingException
	{
		String result = null;
		HttpPost httpPost = new HttpPost(hostAddr);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		if (params != null)
		{
			CloseableHttpResponse response = null;
			try {
				UrlEncodedFormEntity formEntiry = HttpClientHandler.buildUrlEncodedFormEntity(params);
				httpPost.setEntity(formEntiry);
				response = httpclient.execute(httpPost);
				HttpEntity entity = response.getEntity();
				if (response.getStatusLine().getReasonPhrase().equals("OK") && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
					result = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}finally
			{
				if(response!=null){
					try {
						response.close();
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				}
			}
		}
		return result;
	}
}
