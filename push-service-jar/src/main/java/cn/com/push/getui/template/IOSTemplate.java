package cn.com.push.getui.template;

import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class IOSTemplate {
	static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
	static String appKey = "NFKrz1sHdd73a22I95In46";
	static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";

	static String CID = "aa4c5a4f6e125959496ac28cb0e8f725";
	static String host = "http://sdk.open.api.igexin.com/apiex.htm";
	public static TransmissionTemplate getTemplate() {
	    TransmissionTemplate template = new TransmissionTemplate();
	    template.setAppId(appId);
	    template.setAppkey(appKey);
	    template.setTransmissionContent("透传内容");
	    template.setTransmissionType(2);
	    APNPayload payload = new APNPayload();
	    payload.setAutoBadge("+1");
	    payload.setContentAvailable(1);
	    payload.setSound("default");
	    payload.setCategory("$由客户端定义");
	    //简单模式APNPayload.SimpleMsg 
	    //payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
	    //字典模式使用下者
	    payload.setAlertMsg(getDictionaryAlertMsg());
	    template.setAPNInfo(payload);
	    return template;
	}
	private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(){
	    APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
	    alertMsg.setBody("body");
	    alertMsg.setActionLocKey("ActionLockey");
	    alertMsg.setLocKey("LocKey");
	    alertMsg.addLocArg("loc-args");
	    alertMsg.setLaunchImage("launch-image");
	    // IOS8.2以上版本支持
	    alertMsg.setTitle("Title");
	    alertMsg.setTitleLocKey("TitleLocKey");
	    alertMsg.addTitleLocArg("TitleLocArg");
	    return alertMsg;
	}
	
	public static void main(String[] args) {

	}
}
