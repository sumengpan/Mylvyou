package com.smp.domain;

public class ResponseInfo {
    //浏览器数据
    private int code;
    private Object data;

    //空
    public ResponseInfo() {
    }

    //全
    public ResponseInfo(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
