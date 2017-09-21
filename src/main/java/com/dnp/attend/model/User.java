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
 * 用户信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-09-21
 */

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "user", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @XmlAttribute
    @ApiModelProperty(value = "用户id", dataType = "Integer", required = true)
    private Integer id;
    /**
     * 用户名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户名称", dataType = "String", required = false)
    private String name;
    /**
     * 用户email
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户email", dataType = "String", required = false)
    private String email;
    /**
     * 用户密码
     */

    @XmlAttribute
    @ApiModelProperty(value = "用户密码", dataType = "String", required = false)
    private String password;
    /**
     * 用户创建日期
     */
    @Column(name = "created_date")

    @XmlAttribute
    @ApiModelProperty(value = "用户创建日期", dataType = "Long", required = false)
    private Long createdDate;
    /**
     * 角色id
     */
    @Column(name = "role_id")

    @XmlAttribute
    @ApiModelProperty(value = "角色id", dataType = "Integer", required = false)
    private Integer roleId;


    public User() {
    }


    public User(
            String name
            ,
            String email
            ,
            String password
            ,
            Long createdDate
            ,
            Integer roleId
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.roleId = roleId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
