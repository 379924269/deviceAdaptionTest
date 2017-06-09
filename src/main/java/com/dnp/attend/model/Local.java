package com.dnp.attend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * 归属地信息
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "local")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "local", description = "归属地信息")
public class Local implements Serializable {

	public Local() {
		super();
	}

	public Local(String name) {
		super();
		this.name = name;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * 归属地id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	@ApiModelProperty(value = "归属地id", dataType = "Integer", required = true)
	private Integer id;
	/**
	 * 归属地名称
	 */

	@XmlAttribute
	@ApiModelProperty(value = "归属地名称", dataType = "String", required = false)
	private String name;

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

}
