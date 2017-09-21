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
 * 资源权限信息
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */

@XmlRootElement(name = "resource")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "resource", description = "资源权限信息")
public class Resource implements Serializable {

    public Resource() {
        super();
    }

    public Resource(String name, Integer parentId, String resKey, String resUrl) {
        super();
        this.name = name;
        this.parentId = parentId;
        this.resKey = resKey;
        this.resUrl = resUrl;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 资源id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlAttribute
    @ApiModelProperty(value = "资源id", dataType = "Integer", required = true)
    private Integer id;
    /**
     * 资源名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "资源名称", dataType = "String", required = false)
    private String name;
    /**
     * 资源父节点
     */
    @Column(name = "parent_id")
    @XmlAttribute
    @ApiModelProperty(value = "资源父节点", dataType = "Integer", required = false)
    private Integer parentId;
    /**
     * 资源key
     */
    @Column(name = "res_key")
    @XmlAttribute
    @ApiModelProperty(value = "资源key", dataType = "String", required = false)
    private String resKey;
    /**
     * 资源value
     */
    @Column(name = "res_url")
    @XmlAttribute
    @ApiModelProperty(value = "资源value", dataType = "String", required = false)
    private String resUrl;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getResKey() {
        return resKey;
    }

    public void setResKey(String resKey) {
        this.resKey = resKey;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

}
