package me.cxis.agw.chains;

import org.apache.commons.chain.impl.ContextBase;

import java.util.Map;

import static me.cxis.agw.constants.Constants.*;

public class CommonContext extends ContextBase {

    private static final long serialVersionUID = -544055049501388556L;

    private int retCode;

    private String retMsg;

    private boolean success;

    private Object retModel;

    private Map<String, String> reqParams;

    private String clientIp;

    public String getSignature() {
        return reqParams.get(SIGNATURE);
    }

    public String getOutName() {
        return reqParams.get(OUT_NAME);
    }

    public String getParam() {
        return reqParams.get(PARAM);
    }

    public String getNonce() {
        return reqParams.get(NONCE);
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getRetModel() {
        return retModel;
    }

    public void setRetModel(Object retModel) {
        this.retModel = retModel;
    }

    public Map<String, String> getReqParams() {
        return reqParams;
    }

    public void setReqParams(Map<String, String> reqParams) {
        this.reqParams = reqParams;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
