package com.dnp.attend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 成功或失败返回的结果
 *
 * @Author 华仔
 * @Author 2017/9/25 9:19
 */
@XmlRootElement(name = "responseResultVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "responseResulTemptVo", description = "响应结果")
public class ResponseResulTemptVo<T> {

    /**
     * 响应状态
     */
    @XmlElement(name = "code")
    @ApiModelProperty(value = "返回状态吗", dataType = "Integer")
    public int code;
    /**
     * 返回类型：成功，失败，异常
     */
    @XmlElement(name = "type")
    @ApiModelProperty(value = "返回结果类型，如：true、false、error、exception", dataType = "string")
    public String type;
    /**
     * 成功、失败或异常消息常
     */
    @XmlElement(name = "message")
    @ApiModelProperty(value = "返回消息", dataType = "object")
    public T message;

    public ResponseResulTemptVo(int code, String type, T message) {
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

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
