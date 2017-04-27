package cn.com.push.getui.advancedpushmessage;

import com.gexin.rp.sdk.base.IAliasResult;
import com.gexin.rp.sdk.http.IGtPush;

public class AliasFunction {
   //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
	static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
    static String appKey = "NFKrz1sHdd73a22I95In46";
    static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";
	static String CID = "aa4c5a4f6e125959496ac28cb0e8f725";
	
	static String host = "http://sdk.open.api.igexin.com/apiex.htm";
    static String Alias = "15736759029";
	
	public static void main(String[] args) throws Exception {
	    IGtPush push = new IGtPush(host, appKey, masterSecret);
	
	    IAliasResult bindSCid = push.bindAlias(appId, Alias, CID);
	    System.out.println("绑定结果：" + bindSCid.getResult() + "错误码:" + bindSCid.getErrorMsg());
	
	}
}