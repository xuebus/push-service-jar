package cn.com.push.getui.advancedpushmessage;

import com.gexin.rp.sdk.base.IAliasResult;
import com.gexin.rp.sdk.http.IGtPush;

public class AliasFunction5 {
   //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
   static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
    static String appKey = "NFKrz1sHdd73a22I95In46";
    static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";
    static String CID = "e605a0db5ce3cca9b76b012978064940";
    static String Alias = "15736759029";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws Exception {
       IGtPush push = new IGtPush(host, appKey, masterSecret);

       IAliasResult AliasUnBindAll = push.unBindAliasAll(appId, Alias);
       System.out.println("解除绑定结果:" + AliasUnBindAll.getResult());
    }
}