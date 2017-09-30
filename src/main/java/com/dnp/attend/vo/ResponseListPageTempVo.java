package com.dnp.attend.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @Author 华仔
 * @Author 2017/9/25 14:08
 */
@XmlRootElement(name = "responseListVo")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(value = "分页查询结果", description = "分页查询结果")
public class ResponseListPageTempVo<T> {
    @XmlElement(name = "total")
    @ApiModelProperty(value = "列总条数", dataType = "Integer")
    public int total;
    @XmlElement(name = "rows")
    @ApiModelProperty(value = "分页后每一列的详情", dataType = "list")
    public List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
