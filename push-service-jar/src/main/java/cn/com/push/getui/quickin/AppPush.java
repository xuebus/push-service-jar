package cn.com.push.getui.quickin;


import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AppPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
    static String appKey = "NFKrz1sHdd73a22I95In46";
    static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws IOException {

        IGtPush push = new IGtPush(url, appKey, masterSecret);
        push.connect();


       /* // 定义"点击链接打开通知模板"，并设置标题、内容、链接
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTitle("马晓东!");
        template.setText("这是一条推送消息~");
        template.setUrl("");*/

        NotificationTemplate template1 = new NotificationTemplate();
        template1.setAppId(appId);
        template1.setAppkey(appKey);
        template1.setTitle("马晓东!");
        template1.setText("这是一条推送消息~");



        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);
        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template1);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);

        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }
}