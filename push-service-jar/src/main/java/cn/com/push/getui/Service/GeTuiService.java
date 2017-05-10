package cn.com.push.getui.Service;

import cn.com.push.exception.PushApiException;

import java.util.Map;

/**
 * 运用第三方GeTui的封装接口
 * Created by Maxd on 2017/3/28.
 */
public interface GeTuiService {

    /**
     * 个推用户的别名与CID绑定
     * @param alias
     * @param cid
     * @return
     */
    public boolean AliasBinDingFunction(String alias, String cid) throws PushApiException;

    /**
     * 个推用户的别名与CID解绑
     * @param alias
     * @param cid
     * @return
     */
    public boolean UnBindDingFunction(String alias, String cid) throws PushApiException;


    /**
     * 安卓、IOS透传推送服务接口，按照别名推送
     * @param alias
     * @param map
     * @return
     */
    public boolean AndroidAndIosPushtoSingle(String alias, Map map) throws PushApiException;


    /**
     * 安卓、IOS透传推送服务接口，按照别名推送,只推送标题和内容
     * @param alias
     * @param title
     * @param message
     * @return
     * @throws PushApiException
     */
    public boolean AndroidAndIosPushtoSingle(String alias, String title,String message) throws PushApiException;

}
