package cn.com.push.config;

/**
 * 个推的配置实体类
 * Created by maxd on 2017/3/28.
 */
public class GeTuiConfig {

    public static String appId;
    public static String appKey;
    public static String masterSecret;
    //请求个推的地址
    public static String hostUrl;

    //构造函数，创建默认值
    public GeTuiConfig(String appId,String appKey,String masterSecret,String hostUrl){
        this.appId  = appId;
        this.appKey = appKey;
        this.masterSecret = masterSecret;
        this.hostUrl = hostUrl;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getAppKey() {
        return appKey;
    }

    public static String getMasterSecret() {
        return masterSecret;
    }

    public static String getHostUrl() {
        return hostUrl;
    }
}
