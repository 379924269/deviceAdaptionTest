package com.dnp.attend.vo;

/**
 * @Author 华仔
 * @Author 2017/9/25 9:19
 */
public class ResponseResultVo {

    public int code;
    public String type;
    public String message;

    public ResponseResultVo(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
