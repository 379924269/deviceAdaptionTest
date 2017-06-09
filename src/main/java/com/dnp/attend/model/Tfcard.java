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

	public Tfcard() {
		super();
	}

	public Tfcard(String tfSn) {
		super();
		this.tfSn = tfSn;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * tf卡id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	@ApiModelProperty(value = "tf卡id", dataType = "Integer", required = true)
	private Integer id;
	/**
	 * tf卡的序列号
	 */
	@Column(name = "tf_sn")
	@XmlAttribute
	@ApiModelProperty(value = "tf卡的序列号", dataType = "String", required = false)
	private String tfSn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTfSn() {
		return tfSn;
	}

	public void setTfSn(String tfSn) {
		this.tfSn = tfSn;
	}

}
