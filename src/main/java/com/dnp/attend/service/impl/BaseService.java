/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.dnp.attend.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import com.dnp.attend.service.IService;
import com.dnp.attend.util.MapUtil;
import com.dnp.attend.vo.PageVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Description: 通用接口的通用的实现类
 * 
 * @since: 2017年5月2日 下午3:35:00
 * 
 * @author xhxing
 */
public abstract class BaseService<T> implements IService<T> {

	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
		return mapper;
	}

	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	public int save(T entity) {
		return mapper.insert(entity);
	}

	public int delete(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	public int updateAll(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	public int updateNotNull(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	public Map<String, Object> selectByExample(PageVo pageVo, String search, String searchField, T t) {
		Example example = new Example(t.getClass());
		Example.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(search)) {
			criteria.andLike(searchField, "%" + search + "%");
		}
		PageHelper.startPage(pageVo.getOffset(), pageVo.getLimit());
		List<T> list = mapper.selectByExample(example);
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return MapUtil.pageInMap((int) pageInfo.getTotal(), pageInfo.getList());
	}

	// TODO 其他...
}
