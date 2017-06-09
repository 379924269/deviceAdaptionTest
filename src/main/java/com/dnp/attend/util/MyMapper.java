package com.dnp.attend.util;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * 
 * @author liuzh_3nofxnp
 * @since 2015-09-06 21:53
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	/**
	 * <p>
	 * 获取所有信息
	 * 
	 * @param search
	 *            模糊查询字段
	 * @return List<Map<String, Object>>
	 */
	List<Map<String, Object>> selectAllPage(@Param("search") String search);
}
