package me.cxis.agw.model;

public enum ErrorCode {

    SYSTEM_ERROR(1, "系统错误"),
    PARAM_ERROR(2, "参数错误"),
    FREQUENTLY_ACCESS(3, "访问太频繁了"),
    IP_NOT_ALLOWED(4, "禁止访问"),
    OUT_CHANNEL_NOT_EXIST(5, "外部渠道不存在"),
    SIGNATURE_ERROR(6, "签名错误"),
    DECODE_DATA_ERROR(7, "解码错误"),
    API_NOT_EXIST(8, "API不存在"),
    SYS_NOT_EXIST(9, "API系统不存在"),
    PARAM_MISSING(10, "缺少参数"),
    SERVICE_ERROR(11, "服务出错")
    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
