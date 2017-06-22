package com.dnp.attend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 配置信息
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "config", description = "配置信息")
public class Config implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 配置id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	@ApiModelProperty(value = "配置id", dataType = "Integer", required = true)
	private Integer id;
	/**
	 * 配置名称
	 */

	@XmlAttribute
	@ApiModelProperty(value = "配置名称", dataType = "String", required = false)
	private String name;
	/**
	 * 配置内容,JSON字符串
	 */

	@XmlAttribute
	@ApiModelProperty(value = "配置内容,JSON字符串", dataType = "String", required = false)
	private String content;
	/**
	 * 配置创建时间
	 */
	@Column(name = "created_date")
	@XmlAttribute
	@ApiModelProperty(value = "配置创建时间", dataType = "Date", required = false)
	private Date createdDate;

	/**
	 * 归属地id
	 */
	@Column(name = "location_id")
	@XmlAttribute
	@ApiModelProperty(value = "归属地id", dataType = "Integer", required = false)
	private Integer locationId;
	/**
	 * 型号id
	 */
	@Column(name = "model_id")
	@XmlAttribute
	@ApiModelProperty(value = "型号id", dataType = "Integer", required = false)
	private Integer modelId;

	public Config() {
		super();
	}

	public Config(String name, String content, Integer locationId, Integer modelId) {
		this.name = name;
		this.content = content;
		this.locationId = locationId;
		this.modelId = modelId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
