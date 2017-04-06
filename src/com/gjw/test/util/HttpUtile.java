package com.gjw.test.util;

import java.util.HashMap;
import java.util.Map;

public class HttpUtile {
	
	/**
	 * 将返回的参数以Map方式存储
	 * @param result_str
	 * @return
	 */
	public static Map<String, String> getParamMap(String result_str) {
		Map<String, String> map = new HashMap<String, String>();
		String[] s1 = result_str.split("&");
		for (int i = 0; i < s1.length; i++) {
			String str = s1[i];
			String[] s2 = str.split("=");
			String key =null,value =null;
			for (int j = 0; j < s2.length; j++) {
				if(j==0)
					key = s2[j];
				else
					value = s2[j];
			}
			map.put(key, value);
		}
		return map;
	}
}
