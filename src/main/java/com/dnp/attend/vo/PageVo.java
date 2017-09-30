package com.dnp.attend.vo;

import io.swagger.annotations.ApiModel;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 分页参数
 *
 * @Author 华仔
 * @DATE 2017/9/25 15:14
 */
@XmlRootElement(name = "pageVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "分页参数", description = "分页参数")
public class PageVo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    @XmlAttribute
    @XmlElement(name = "偏移量", required = false)
    private Integer offset;
    @XmlAttribute
    @XmlElement(name = "页大小", required = false)
    private Integer limit;
    @XmlAttribute
    @XmlElement(name = "升序降序", required = false)
    private String order;
    @XmlAttribute
    @XmlElement(name = "排序字段", required = false)
    private String sort;

    public PageVo() {
    }

    public PageVo(Integer offset, Integer limit, String order, String sort) {
        this.offset = offset;
        this.limit = limit;
        this.order = order;
        this.sort = sort;
    }

    public String getOrder() {
        if (StringUtils.isEmpty(order)) {
            this.order = "desc";
        }
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        if (StringUtils.isEmpty(sort)) {
            this.sort = "id";
        }
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        if (null == limit) {
            this.limit = 20;
        }
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        if (null == offset) {
            this.offset = 0;
        }
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
