package me.cxis.agw.sample.tracecenter.result;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6249813965752294035L;

    private boolean success;

    private int code;

    private String msg;

    private T model;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    @Override
    public String toString() {
        return "Result{" +
            "success=" + success +
            ", code=" + code +
            ", msg='" + msg + '\'' +
            ", model=" + model +
            '}';
    }
}
