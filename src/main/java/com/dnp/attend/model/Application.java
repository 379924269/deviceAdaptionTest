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
 * 应用信息
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "application")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "application", description = "应用信息")
public class Application implements Serializable {

	public Application() {
		super();
	}

	public Application(String name, String versionName, String versionCode, String packageName, String system, String md5, Integer size, String url) {
		super();
		this.name = name;
		this.versionName = versionName;
		this.versionCode = versionCode;
		this.packageName = packageName;
		this.system = system;
		this.md5 = md5;
		this.size = size;
		this.url = url;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute
	@ApiModelProperty(value = "id", dataType = "Integer", required = true)
	private Integer id;
	/**
	 * 应用名称
	 */

	@XmlAttribute
	@ApiModelProperty(value = "应用名称", dataType = "String", required = false)
	private String name;
	/**
	 * 应用版本名称
	 */
	@Column(name = "version_name")
	@XmlAttribute
	@ApiModelProperty(value = "应用版本名称", dataType = "String", required = false)
	private String versionName;
	/**
	 * 应用版本号
	 */
	@Column(name = "version_code")
	@XmlAttribute
	@ApiModelProperty(value = "应用版本号", dataType = "String", required = false)
	private String versionCode;
	/**
	 * 应用报名
	 */
	@Column(name = "package_name")
	@XmlAttribute
	@ApiModelProperty(value = "应用报名", dataType = "String", required = false)
	private String packageName;
	/**
	 * 应用版本：如：华为、中心等（包名相同不同版本）
	 */

	@XmlAttribute
	@ApiModelProperty(value = "应用版本：如：华为、中心等（包名相同不同版本）", dataType = "String", required = false)
	private String system;
	/**
	 * 应用MD5
	 */

	@XmlAttribute
	@ApiModelProperty(value = "应用MD5", dataType = "String", required = false)
	private String md5;
	/**
	 * 应用大小
	 */

	@XmlAttribute
	@ApiModelProperty(value = "应用大小", dataType = "Integer", required = false)
	private Integer size;
	/**
	 * 应用地址
	 */

	@XmlAttribute
	@ApiModelProperty(value = "应用地址", dataType = "String", required = false)
	private String url;

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

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
