package com.dnp.attend.vo;

import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author 华仔
 * @Author 2017/9/25 15:27
 */
@XmlRootElement(name = "responseResultStrVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "responseResultStrVo", description = "返回结果")
public class ResponseResultStrVo extends ResponseResulTemptVo<String> {
    public ResponseResultStrVo(int code, String type, String message) {
        super(code, type, message);
    }
}
