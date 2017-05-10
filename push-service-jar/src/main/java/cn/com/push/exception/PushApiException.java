package cn.com.push.exception;

/**
 * 推送异常类
 * Created by maxd on 2017/5/10.
 */
public class PushApiException extends Exception{
    private String errCode;
    private String errMsg;

    public PushApiException() {
        super();
    }

    public PushApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PushApiException(String message) {
        super(message);
    }

    public PushApiException(Throwable cause) {
        super(cause);
    }

    public PushApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
