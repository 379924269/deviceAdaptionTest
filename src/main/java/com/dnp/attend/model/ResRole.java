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
 * 资源角色关系信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Table(name = "res_role")

@XmlRootElement(name = "resRole")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "resRole", description = "资源角色关系信息")
public class ResRole implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 资源角色关系id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @XmlAttribute
    @ApiModelProperty(value = "资源角色关系id", dataType = "Integer", required = true)
    private Integer id;
    /**
     * 资源id
     */
    @Column(name = "resource_id")

    @XmlAttribute
    @ApiModelProperty(value = "资源id", dataType = "Integer", required = false)
    private Integer resourceId;
    /**
     * 角色id
     */
    @Column(name = "role_id")

    @XmlAttribute
    @ApiModelProperty(value = "角色id", dataType = "Integer", required = false)
    private Integer roleId;


    public ResRole() {
    }


    public ResRole(
            Integer resourceId
            ,
            Integer roleId
    ) {
        this.resourceId = resourceId;
        this.roleId = roleId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
