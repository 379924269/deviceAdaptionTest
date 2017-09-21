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
 * 设备信息
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "device", description = "设备信息")
public class Device implements Serializable {

    public Device() {
        super();
    }

    public Device(String serialNumber,
                  Integer downloads,
                  Integer configId,
                  Integer applicationId,
                  Integer localId,
                  Integer modelId,
                  Integer tfcardId,
                  String token,
                  Integer expirationTime) {
        super();
        this.serialNumber = serialNumber;
        this.downloads = downloads;
        this.configId = configId;
        this.applicationId = applicationId;
        this.localId = localId;
        this.modelId = modelId;
        this.tfcardId = tfcardId;
        this.token = token;
        this.expirationTime = expirationTime;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    @ApiModelProperty(value = "设备id", dataType = "Integer", required = true)
    private Integer id;
    /**
     * 设备的SN（序列号）
     */
    @Column(name = "serial_number")
    @XmlAttribute
    @ApiModelProperty(value = "设备的SN（序列号）", dataType = "String", required = false)
    private String serialNumber;
    /**
     * 下载次数
     */

    @XmlAttribute
    @ApiModelProperty(value = "下载次数", dataType = "Integer", required = false)
    private Integer downloads;
    /**
     * 配置id
     */
    @Column(name = "config_id")
    @XmlAttribute
    @ApiModelProperty(value = "配置id", dataType = "Integer", required = false)
    private Integer configId;
    /**
     * 应用id
     */
    @Column(name = "application_id")
    @XmlAttribute
    @ApiModelProperty(value = "应用id", dataType = "Integer", required = false)
    private Integer applicationId;
    /**
     * 归属地id
     */
    @Column(name = "local_id")
    @XmlAttribute
    @ApiModelProperty(value = "归属地id", dataType = "Integer", required = false)
    private Integer localId;
    /**
     * 型号id
     */
    @Column(name = "model_id")
    @XmlAttribute
    @ApiModelProperty(value = "型号id", dataType = "Integer", required = false)
    private Integer modelId;
    /**
     * TF卡id
     */
    @Column(name = "tfcard_id")
    @XmlAttribute
    @ApiModelProperty(value = "TF卡id", dataType = "Integer", required = false)
    private Integer tfcardId;
    /**
     * 设备口令
     */

    @XmlAttribute
    @ApiModelProperty(value = "设备口令", dataType = "String", required = false)
    private String token;
    /**
     * 口令过期过期时间
     */
    @Column(name = "expiration_time")
    @XmlAttribute
    @ApiModelProperty(value = "口令过期过期时间", dataType = "Integer", required = false)
    private Integer expirationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getLocalId() {
        return localId;
    }

    public void setLocalId(Integer localId) {
        this.localId = localId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getTfcardId() {
        return tfcardId;
    }

    public void setTfcardId(Integer tfcardId) {
        this.tfcardId = tfcardId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

}
