package com.dnp.attend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

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
 * TF卡信息
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "tfcard")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "tfcard", description = "TF卡信息")
public class Tfcard implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键代理id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	@ApiModelProperty(value = "主键代理id", dataType = "Integer", required = true)
	private Integer id;
	/**
	 * tf卡id
	 */
	@Column(name = "tf_id")
	@XmlAttribute
	@ApiModelProperty(value = "tf卡id", dataType = "String", required = false)
	private String tfId;
	/**
	 * tf卡的序列号
	 */
	@Column(name = "tf_sn")
	@XmlAttribute
	@ApiModelProperty(value = "tf卡的序列号", dataType = "String", required = false)
	private String tfSn;

	@XmlAttribute
	@ApiModelProperty(value = "", dataType = "Integer", required = false)
	private Integer status;
	/**
	 * 归属地id
	 */
	@Column(name = "location_id")
	@XmlAttribute
	@ApiModelProperty(value = "归属地id", dataType = "Integer", required = false)
	private Integer locationId;

	public Tfcard() {
		// TODO Auto-generated constructor stub
	}

	public Tfcard(String tfId, String tfSn, Integer status, Integer locationId) {
		this.tfId = tfId;
		this.tfSn = tfSn;
		this.status = status;
		this.locationId = locationId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTfId() {
		return tfId;
	}

	public void setTfId(String tfId) {
		this.tfId = tfId;
	}

	public String getTfSn() {
		return tfSn;
	}

	public void setTfSn(String tfSn) {
		this.tfSn = tfSn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
