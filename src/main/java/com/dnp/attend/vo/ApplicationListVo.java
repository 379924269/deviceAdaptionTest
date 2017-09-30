package com.dnp.attend.vo;

import com.dnp.attend.model.Application;
import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 返回结果说明
 *
 * @Author 华仔
 * @Author 2017/9/25 14:40
 */
@XmlRootElement(name = "applicationListVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "应用分页查询结果", description = "应用分页查询结果")
public class ApplicationListVo extends ResponseListPageTempVo<Application> {
}
