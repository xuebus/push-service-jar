package cn.com.push.getui.Service;

import java.util.Map;

/**
 * 运用第三方GeTui的封装接口
 * Created by Maxd on 2017/3/28.
 */
public interface GeTuiService {

    /**
     * 安卓个推用户的别名与CID绑定
     * @param alias
     * @param cid
     * @return
     */
    public boolean AliasBinDingFunction(String alias, String cid);

    /**
     * 对用户进行解绑
     * @param alias
     * @param cid
     * @return
     */
    public boolean UnBindDingFunction(String alias, String cid);


    /**
     * 安卓、IOS透传推送服务接口
     * @param alias
     * @param map
     * @return
     */
    public boolean AndroidAndIosPushtoSingle(String alias, Map map);
}
