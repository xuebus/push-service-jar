package cn.com.push.getui.advancedpushmessage;

import com.gexin.rp.sdk.base.IAliasResult;
import com.gexin.rp.sdk.http.IGtPush;

public class AliasFunction4 {
   //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
   static String appId = "Pb6NgP1ZqH8U3nOQsYpqq5";
    static String appKey = "NFKrz1sHdd73a22I95In46";
    static String masterSecret = "gvo0GjkXCz68X9AkX8zjl1";

    static String CID = "f560cb4a4234e94ab2fe3920c59744dd";
    static String Alias = "15167103012";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void AliasUnBind() throws Exception {
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        IAliasResult AliasUnBind = push.unBindAlias(appId, Alias, CID);
        System.out.println("解除绑定结果:" + AliasUnBind.getResult());
    }
    
    public static void main(String[] args) {
		try {
			AliasUnBind();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}