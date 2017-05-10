package cn.com.push.getui.Service.impl;




import cn.com.push.config.GeTuiConfig;
import cn.com.push.getui.Service.GeTuiService;
import cn.com.push.getui.template.TransmissionTemplateDemo;
import com.gexin.rp.sdk.base.IAliasResult;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 推送相关业务
 * Created by Maxd on 2017/3/28.
 */
@Service
public class GeTuiServiceImpl implements GeTuiService {

    private String  appId        = GeTuiConfig.appId;
    private String  appKey       = GeTuiConfig.appKey;
    private String  masterSecret = GeTuiConfig.masterSecret;
    private String  hostUrl      = GeTuiConfig.hostUrl;

    @Override
    public boolean AliasBinDingFunction(String alias, String cid) {
        IGtPush push = new IGtPush(hostUrl, appKey, masterSecret);
        IAliasResult bindSCid = push.bindAlias(appId, alias, cid);
        if(bindSCid.getResult()){
            System.out.println("=========================>>绑定成功........");
            return true;
        }else{
            System.out.println("=========================>>绑定失败.........");
            System.out.println("=========================>>失败原因:"+bindSCid.getErrorMsg());
            return false;
        }
    }
    @Override
    public boolean UnBindDingFunction(String alias, String cid) {
        IGtPush push = new IGtPush(hostUrl, appKey, masterSecret);
        IAliasResult aliasUnBind = push.unBindAlias(appId, alias, cid);
        if(aliasUnBind.getResult()){
            System.out.println("=========================>>解绑成功........");
            return true;
        }else{
            System.out.println("=========================>>解绑失败.........");
            System.out.println("=========================>>失败原因:"+aliasUnBind.getErrorMsg());
            return false;
        }
    }

    @Override
    public boolean AndroidAndIosPushtoSingle(String alias, Map map) {
        IGtPush push = new IGtPush(hostUrl, appKey, masterSecret);
        TransmissionTemplate template = TransmissionTemplateDemo.transmissionTemplateDemo(appId,appKey,map);
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setAlias(alias);
        IPushResult ret;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
            return true;
        } else {
            System.out.println("=========================>>安卓、IOS透传推送服务，服务器响应异常.........");
            return false;
        }
    }
}
