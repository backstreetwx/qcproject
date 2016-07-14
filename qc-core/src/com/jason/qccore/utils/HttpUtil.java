package com.jason.qccore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String postMethod(String url, Map<String, String> params){
		String result = null;
		CloseableHttpClient httpclient = null;
		try {
			httpclient = HttpClients.createDefault();
			HttpPost httpost = new HttpPost(url); 
			// 判断是否POST请求具有参数
			if(params != null && params.size() > 0){
				List<NameValuePair> nvps = new ArrayList <NameValuePair>();  
				Set<String> keySet = params.keySet(); 
				for(String key : keySet) {  
				    nvps.add(new BasicNameValuePair(key, params.get(key)));  
				}  
				httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			}
			
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
			// 消耗实体
			EntityUtils.consume(entity);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("action", "dovote");
		params.put("guid", "37577ba9-b0e3-6ef5-0c07-0937167ce1e9");
		params.put("ops", "1503008");
		params.put("wxparam", "oPMGouBV_bEBApQSaGeHy2hlDKNg|37577ba9-b0e3-6ef5-0c07-0937167ce1e9|89b8fcd373edeeee22cd0022b51a9c4e|cd50e1be3f23537fb0b65c97d2afd512|vote");
		String result = postMethod("http://pwx.a.mvote.net/op.php", params);
		System.out.println(result);
	}
}
