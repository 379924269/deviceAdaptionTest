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

import com.dnp.attend.model.Tfcard;
import com.dnp.attend.service.TfcardService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * TF卡信息 前端控制器
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "TfcardController", description = "TF卡信息")
@RestController
@RequestMapping(value = "/tfcard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TfcardController {

	@Autowired
	private TfcardService tfcardService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "查询所有TF卡信息", notes = "查询所有TF卡信息")
	public Object findAll(PageVo pageVo,
			@ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
		Tfcard tfcard = new Tfcard();
		return tfcardService.selectByExample(pageVo, search, "", tfcard);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查询TF卡信息详情", notes = "查询TF卡信息详情", httpMethod = "GET")
	public Tfcard findById(@ApiParam(name = "id", value = "TF卡信息id", required = true) @PathVariable("id") Integer id) {
		return tfcardService.selectByKey(id);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "修改TF卡信息", notes = "修改TF卡信息")
	public void update(Tfcard tfcard) {
		tfcardService.updateAll(tfcard);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation(value = "添加TF卡信息", notes = "添加TF卡信息")
	public void save(@ApiParam(name = "tfId", value = "tf卡id", required = false) @RequestParam(required = false) String tfId,
			@ApiParam(name = "tfSn", value = "tf卡的序列号", required = false) @RequestParam(required = false) String tfSn,
			@ApiParam(name = "status", value = "tf卡的状态", required = false) @RequestParam(required = false) Integer status,
			@ApiParam(name = "locationId", value = "tf卡归属地id", required = false) @RequestParam(required = false) Integer locationId) {
		Tfcard tfcard = new Tfcard(tfId, tfSn, status, locationId);
		tfcardService.save(tfcard);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除TF卡信息", notes = "修改TF卡信息")
	public void delete(@ApiParam(name = "id", value = "TF卡信息id", required = true) @PathVariable("id") Integer id) {
		tfcardService.delete(id);
	}

}
