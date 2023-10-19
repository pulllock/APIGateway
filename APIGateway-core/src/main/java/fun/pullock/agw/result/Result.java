package fun.pullock.agw.result;

import fun.pullock.agw.model.ErrorCode;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8463830912199580065L;

    private boolean success = true;

    private int code;

    private String msg;

    private T model;

    private int nonce;

    private String sign;

    public Result() {
    }

    public Result(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.success = false;
    }

    public Result(ErrorCode errorCode, String extMsg) {
        this.code = errorCode.getCode();
        this.msg = String.format("%s %s", errorCode.getMsg(), extMsg);
        this.success = false;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Result{" +
            "success=" + success +
            ", code=" + code +
            ", msg='" + msg + '\'' +
            ", model=" + model +
            ", nonce=" + nonce +
            ", sign='" + sign + '\'' +
            '}';
    }
}
