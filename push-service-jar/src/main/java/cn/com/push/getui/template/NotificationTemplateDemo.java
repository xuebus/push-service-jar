package cn.com.push.getui.template;

import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style1;

import java.util.Map;

public class NotificationTemplateDemo {

	public static NotificationTemplate notificationTemplateDemo(String appId, String appkey) {
	    NotificationTemplate template = new NotificationTemplate();
	    // 设置APPID与APPKEY
	    template.setAppId(appId);
	    template.setAppkey(appkey);
	    // 设置通知栏标题与内容
	    template.setTitle("请输入通知栏标题");
	    template.setText("请输入通知栏内容");
	    // 配置通知栏图标
	    template.setLogo("icon.png");
	    // 配置通知栏网络图标
	    template.setLogoUrl("");
	    // 设置通知是否响铃，震动，或者可清除
	    template.setIsRing(true);
	    template.setIsVibrate(true);
	    template.setIsClearable(true);
	    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	    template.setTransmissionType(1);
	    template.setTransmissionContent("请输入您要透传的内容");
	    // 设置定时展示时间
	    // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
	    return template;
	}

	/**
	 * 此方法正在使用，请勿删除。推送
	 * @param appId
	 * @param appkey
	 * @param map
	 * @return
	 */
	public static NotificationTemplate notificationTemplateDemo(String appId, String appkey,Map map) {
		NotificationTemplate template1 = new NotificationTemplate();
		template1.setAppId(appId);
		template1.setAppkey(appkey);
		Style1 style = new Style1();
		style.setLogo("youmeng.png");
		//通知标题
		style.setTitle(map.get("title").toString());
		//通知内容
		style.setText(map.get("text").toString());
		// 设置通知是否响铃，震动，或者可清除
		style.setRing(Boolean.parseBoolean(map.get("ring").toString()));
		style.setVibrate(Boolean.parseBoolean(map.get("vibrate").toString()));
		style.setClearable(true);
		template1.setStyle(style);
		return template1;
	}
}
