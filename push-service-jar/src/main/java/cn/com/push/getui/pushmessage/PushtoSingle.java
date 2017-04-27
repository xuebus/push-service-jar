package cn.com.push.getui.pushmessage;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.gexin.rp.sdk.template.style.Style1;


public class PushtoSingle {
    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
    static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
    static String appKey = "NFKrz1sHdd73a22I95In46";
    static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";

    //static String CID = "aa4c5a4f6e125959496ac28cb0e8f725";
    //别名推送方式
    static String Alias = "15736759029";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws Exception {
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        //NotificationTemplate template = linkTemplateDemo();
        TransmissionTemplate template = getTemplate();
        SingleMessage message = new SingleMessage();
        //数据
        message.setData(template);
        // 离线有效时间，单位为毫秒，可选
        message.setOffline(true);
        message.setOfflineExpireTime(24 * 3600 * 1000);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        //target.setClientId(CID);
        target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }

    public static NotificationTemplate linkTemplateDemo() {
        NotificationTemplate template1 = new NotificationTemplate();
        template1.setAppId(appId);
        template1.setAppkey(appKey);
        Style1 style = new Style1();
        style.setLogo("push.png");
        style.setTitle("马晓东!");
        style.setText("这是一条推送消息~");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template1.setStyle(style);
        //IOS推送需要在代码中通过,setAPNInfo接口设置相应的APNs通知参数
        APNPayload payload = new APNPayload();
        //在已有数字基础上加1显示，设置为-1时，在已有数字上减1显示，设置为数字时，显示指定数字
        payload.setAutoBadge("+1");
        //推送直接带有透传数据
        payload.setContentAvailable(1);
        //通知铃声文件名
        payload.setSound("default");
        //在客户端通知栏触发特定的action和button显示
        payload.setCategory("$由客户端定义");
        //简单模式APNPayload.SimpleMsg
        //通知消息体
        //payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
        //带有标题的通知消息
        //payload.setAlertMsg(getDictionaryAlertMsg());

        template1.setAPNInfo(payload);
        return template1;
    }


    public static TransmissionTemplate getTemplate() {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        //安卓的透传内容
        template.setTransmissionContent("{\"title\":\"xx\",\"message\":\"xxxxxxx\"}");
        //等待应用启动
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
        alertMsg.setBody("你好，这是推送的消息");
        alertMsg.setActionLocKey("ActionLockey");
        alertMsg.setLocKey("你好，这是推送的消息");
        alertMsg.addLocArg("loc-args");
        alertMsg.setLaunchImage("launch-image");
        // iOS8.2以上版本支持
        alertMsg.setTitle("这是标题：");
        alertMsg.setTitleLocKey("这是标题：");
        alertMsg.addTitleLocArg("TitleLocArg");
        return alertMsg;
    }
}
