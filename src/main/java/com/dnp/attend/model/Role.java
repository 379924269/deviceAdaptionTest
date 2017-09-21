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
 * 角色信息
 * </p>
 *
 * @author stylefeng
 * @since 2017-09-21
 */

@XmlRootElement(name = "role")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "role", description = "角色信息")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @XmlAttribute
    @ApiModelProperty(value = "角色id", dataType = "Integer", required = true)
    private Integer id;
    /**
     * 角色名称
     */

    @XmlAttribute
    @ApiModelProperty(value = "角色名称", dataType = "String", required = false)
    private String name;
    /**
     * 角色描述
     */

    @XmlAttribute
    @ApiModelProperty(value = "角色描述", dataType = "String", required = false)
    private String description;


    public Role() {
    }


    public Role(
            String name
            ,
            String description
    ) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
