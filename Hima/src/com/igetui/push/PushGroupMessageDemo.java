package com.igetui.push;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gexin.platform.open.client.util.HttpUtil;
import com.gexin.platform.open.client.util.SignUtil;


public class PushGroupMessageDemo {
	private static final String APPID = "您应用的AppID";
	private static final String APPKEY = "您应用的AppKey";
	private static final String MASTERSECRET = "您应用的MasterSecret";
	

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("action", "pushGroupMessage");		 //pushGroupMessage为接口名，注意大小写
		/*---以下代码用于设定接口相应参数---*/
		param.put("appkey", APPKEY);
		param.put("type", 2);							 //推送类型：2为消息 
		param.put("pushTitle","hello title");	 			 //pushTitle请填写您的应用名称
		//推送消息类型，有TransmissionMsg、LinkMsg、NotifyMsg三种，此处以NotifyMsg举例
		param.put("pushType", "NotifyMsg");
		param.put("offline", false); 		 				 //是否进入离线消息
		param.put("priority", 1);						 //推送任务优先级
		param.put("isDirected", false);					//推是否定向推送
		
		
		//notifyMsg消息实体
		Map<String, Object> notifyMsg=new HashMap<String, Object>();
		notifyMsg.put("notifyMsgIcon", "push.png");						//消息在通知栏的图标
		notifyMsg.put("notifyMsgTitle", "推送消息标题");					//推送消息的标题
		notifyMsg.put("notifyMsgContent","推送消息的内容…");			//推送消息的内容
		notifyMsg.put("transmissionContent", "我是透传内容");
		notifyMsg.put("transmissionType", 1);
		param.put("msg", notifyMsg);		

		
		List<String> appidList=new ArrayList<String>();
		appidList.add(APPID);
		param.put("appIdList", appidList);				//客户端应用标识列表，对应您应用的AppID
		

		//生成Sign值，用于鉴权
		param.put("sign", SignUtil.makeSign(MASTERSECRET , param));
         /*--- 
　　　　如果你使用非java语言进行编码，则可以按如下规则计算sign值。
　　　　sign=md5(mastersecret +”action”+ pushGroupMessage +…….)
　　　　排序规则第一个为mastersecret值（该值不在参数序列中），之后是根据参数的
　　　　key值英文字母序排列（本次包中没有包含该key的则不需要列入），
　　　　最后获得masterSecret+key值+value值取和之后求其md5值
　　　　（参与求和的类型有：String，Long，Integer共三种类型; ）
　　　　---*/
		System.out.println(param);
		//调用远程接口
		Map<String, Object> retValue = post(param);
		System.out.println(retValue);
	}

	private static Map<String, Object> post(Map<String, Object> param) {
		//OpenService接口地址
		return HttpUtil.httpPostJSON("http://sdk.open.api.igexin.com/service", param);
	}
}