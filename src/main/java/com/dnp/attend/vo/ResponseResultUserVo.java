package com.dnp.attend.vo;

import com.dnp.attend.model.User;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户错误结果返回
 *
 * @Author 华仔
 * @Author 2017/9/25 15:27
 */
@XmlRootElement(name = "responseResultUserVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "responseResultUserVo", description = "返回结果")
public class ResponseResultUserVo extends ResponseResulTemptVo<User> {

    public ResponseResultUserVo(int code, String type, User message) {
        super(code, type, message);
    }
}
