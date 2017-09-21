package

        com.dnp.attend.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>
 * TF卡信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-09-21
 */

@XmlRootElement(name = "tfcard")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "tfcard", description = "TF卡信息")
public class Tfcard implements Serializable {

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
    /**
     * -1:停用,0:未使用,1:使用
     */

    @XmlAttribute
    @ApiModelProperty(value = "-1:停用,0:未使用,1:使用", dataType = "Integer", required = false)
    private Integer status;
    /**
     * 归属地id
     */
    @Column(name = "location_id")

    @XmlAttribute
    @ApiModelProperty(value = "归属地id", dataType = "Integer", required = false)
    private Integer locationId;
    /**
     * tf卡创建时间
     */
    @Column(name = "created_date")

    @XmlAttribute
    @ApiModelProperty(value = "tf卡创建时间", dataType = "Long", required = false)
    private Long createdDate;


    public Tfcard() {
    }


    public Tfcard(
            String tfId
            ,
            String tfSn
            ,
            Integer status
            ,
            Integer locationId
            ,
            Long createdDate
    ) {
        this.tfId = tfId;
        this.tfSn = tfSn;
        this.status = status;
        this.locationId = locationId;
        this.createdDate = createdDate;
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

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

}
