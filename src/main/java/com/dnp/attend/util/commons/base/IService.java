package com.dnp.attend.util.commons.base;

import com.dnp.attend.vo.PageVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 通用service接口
 *
 * @Author 华仔
 * @DATE 2017/9/21 15:19
 */
@Service
public interface IService<T> {

    /**
     * 通过id获取实体类
     *
     * @param key id
     * @return 实体类
     */
    T selectByKey(Object key);

    /**
     * 添加信息，为空字段不添加，使用数据库默认值
     *
     * @param entity 实体类
     * @return 该条信息id
     */
    int save(T entity);

    /**
     * 通过id删除信息
     *
     * @param key id
     * @return 删除条数
     */
    int delete(Object key);

    /**
     * 通过id修改所有
     *
     * @param entity 实体类
     * @return 修改条数
     */
    int updateAll(T entity);

    /**
     * 通过id修改所有不为空的字段
     *
     * @param entity 实体类
     * @return 修改条数
     */
    int updateNotNull(T entity);

    /**
     * 获取所有信息
     *
     * @param pageVo      分页参数
     * @param search      模糊查询参数
     * @param searchField 模糊查询字段，如“id”或“name”等
     * @param t           实体类,如：new Application（）
     * @return 封装好了的分页结果：{total:1, rows:[xxx,xxx]}
     */
    Map<String, Object> selectByExample(PageVo pageVo, String search, String searchField, T t);
}
