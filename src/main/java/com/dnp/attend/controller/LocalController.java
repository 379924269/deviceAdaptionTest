package com.dnp.attend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnp.attend.model.Local;
import com.dnp.attend.service.LocalService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 归属地信息 前端控制器
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "LocalController", description = "归属地信息")
@RestController
@RequestMapping(value = "/local", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LocalController {

	@Autowired
	private LocalService localService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "查询所有归属地信息", notes = "查询所有归属地信息")
	public Object findAll(PageVo pageVo,
			@ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
		Local local = new Local();
		return localService.selectByExample(pageVo, search, "", local);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查询归属地信息详情", notes = "查询归属地信息详情", httpMethod = "GET")
	public Local findById(@ApiParam(name = "id", value = "归属地信息id", required = true) @PathVariable("id") Integer id) {
		return localService.selectByKey(id);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "修改归属地信息", notes = "修改归属地信息")
	public void update(Local local) {
		localService.updateAll(local);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation(value = "添加归属地信息", notes = "添加归属地信息")
	public void save(@ApiParam(name = "name", value = "归属地名称", required = false) @RequestParam(required = false) String name) {
		Local local = new Local(name);
		localService.save(local);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除归属地信息", notes = "修改归属地信息")
	public void delete(@ApiParam(name = "id", value = "归属地信息id", required = true) @PathVariable("id") Integer id) {
		localService.delete(id);
	}

}
