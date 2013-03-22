package com.igetui.push;

import java.util.HashMap;
import java.util.Map;
import com.gexin.platform.open.client.util.HttpUtil;
import com.gexin.platform.open.client.util.SignUtil;

public class PushMessageDemo {
	private static final String APPID = "NMxEdx5Cb06T3qUpWbbi16";
	private static final String APPKEY = "ONRrS4QEOX6KRP2hiRVgq8";
	private static final String MASTERSECRET = "xHVT8YQWGZ6vMP1g7gzlr9";
	private static final String CLIENTID = "423118008bd668fcb3bf77283aa3a12e";

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("action", "pushmessage");			 //pushmessageΪ�ӿ���ע��ȫ��Сд
		/*---���´��������趨�ӿ���Ӧ����---*/
		param.put("appkey", APPKEY);
		param.put("appid", APPID);
        //ע��͸�����ݺ�����������֤�ӿڵ����Ƿ�ɹ����ٶ���дΪhello girl~
		param.put("data", "阿斯蒂芬");	
		param.put("time", "2012-05-20 13:14:15");		//��ǰ����ʱ�䣬��ѡ
		param.put("clientid", CLIENTID);				//���ȡ��ClientID
//		03-21 11:30:34.873: E/GexinMainService(6939): clientid is 423118008bd668fcb3bf77283aa3a12e
		param.put("expire", 3600);					//��Ϣ��ʱʱ�䣬��λΪ�룬��ѡ
		
		// ���Signֵ�����ڼ�Ȩ
		param.put("sign", SignUtil.makeSign(MASTERSECRET , param));
         /*--- 
�������������ʹ�÷�java���Խ��б��룬����԰����¹������signֵ��
��������sign=md5(mastersecret +��action��+pushmessage+����.)
����������������һ��Ϊmastersecretֵ����ֵ���ڲ��������У���֮���Ǹ�ݲ����
��������keyֵӢ����ĸ�����У����ΰ���û�а��key������Ҫ���룩��
�������������masterSecret+keyֵ+valueֵȡ��֮������md5ֵ
����������������͵������У�String��Long��Integer����������; ��
��������---*/
		System.out.println(param);
		// ����Զ�̽ӿ�
		Map<String, Object> retValue = post(param);
		System.out.println(retValue);
	}

	private static Map<String, Object> post(Map<String, Object> param) {
		//OpenService�ӿڵ�ַ
		return HttpUtil.httpPostJSON("http://sdk.open.api.igexin.com/service", param);
	}
}