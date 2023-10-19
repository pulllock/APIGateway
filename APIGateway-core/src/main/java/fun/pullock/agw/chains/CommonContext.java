package fun.pullock.agw.chains;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import fun.pullock.agw.constants.Constants;
import fun.pullock.agw.dao.model.ApiDO;
import org.apache.commons.chain.impl.ContextBase;

import java.util.Map;

public class CommonContext extends ContextBase {

    private static final long serialVersionUID = -544055049501388556L;

    private int retCode;

    private String retMsg;

    private boolean success;

    private Object retModel;

    private int retNonce;

    private String retSign;

    private Map<String, String> reqParams;

    private String clientIp;

    private String[] paramTypes;

    private Object[] params;

    private ApiDO apiDO;

    public String getSignature() {
        return reqParams.get(Constants.SIGNATURE);
    }

    public String getOutName() {
        return reqParams.get(Constants.OUT_NAME);
    }

    public String getParam() {
        return reqParams.get(Constants.PARAM);
    }

    public String getNonce() {
        return reqParams.get(Constants.NONCE);
    }

    public String getApiCode() {
        return reqParams.get(Constants.API_CODE);
    }

    public String getSys() {
        return reqParams.get(Constants.SYS);
    }

    public Map<String, String> getReqParamData() {
        return JSON.parseObject(reqParams.get(Constants.DATA), new TypeReference<Map<String, String>>(){});
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

    public String[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(String[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public ApiDO getApiDO() {
        return apiDO;
    }

    public void setApiDO(ApiDO apiDO) {
        this.apiDO = apiDO;
    }

    public int getRetNonce() {
        return retNonce;
    }

    public void setRetNonce(int retNonce) {
        this.retNonce = retNonce;
    }

    public String getRetSign() {
        return retSign;
    }

    public void setRetSign(String retSign) {
        this.retSign = retSign;
    }
}
