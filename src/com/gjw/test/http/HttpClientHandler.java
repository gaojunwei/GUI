package com.gjw.test.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientHandler {

    /**
     * MAP类型数组转换成buildUrlEncodedFormEntity类型
     * @throws UnsupportedEncodingException 
     */
    public static UrlEncodedFormEntity buildUrlEncodedFormEntity(Map<String, String> params) throws UnsupportedEncodingException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        UrlEncodedFormEntity formEntity = null;
        formEntity = new UrlEncodedFormEntity(nvps,"UTF-8");
        return formEntity;
    }
    
    
}
