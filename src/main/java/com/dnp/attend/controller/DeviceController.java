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

import com.dnp.attend.model.Device;
import com.dnp.attend.service.DeviceService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 设备信息 前端控制器
 * </p>
 * 
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "DeviceController", description = "设备信息")
@RestController
@RequestMapping(value = "/device", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ApiOperation(value = "查询所有设备信息", notes = "查询所有设备信息")
	public Object findAll(PageVo pageVo,
			@ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
		Device device = new Device();
		return deviceService.selectByExample(pageVo, search, "", device);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查询设备信息详情", notes = "查询设备信息详情", httpMethod = "GET")
	public Device findById(@ApiParam(name = "id", value = "设备信息id", required = true) @PathVariable("id") Integer id) {
		return deviceService.selectByKey(id);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ApiOperation(value = "修改设备信息", notes = "修改设备信息")
	public void update(Device device) {
		deviceService.updateAll(device);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ApiOperation(value = "添加设备信息", notes = "添加设备信息")
	public void save(@ApiParam(name = "serialNumber", value = "设备的SN（序列号）", required = false) @RequestParam(required = false) String serialNumber,
			@ApiParam(name = "downloads", value = "下载次数", required = false) @RequestParam(required = false) Integer downloads,
			@ApiParam(name = "configId", value = "配置id", required = false) @RequestParam(required = false) Integer configId,
			@ApiParam(name = "applicationId", value = "应用id", required = false) @RequestParam(required = false) Integer applicationId,
			@ApiParam(name = "localId", value = "归属地id", required = false) @RequestParam(required = false) Integer localId,
			@ApiParam(name = "modelId", value = "型号id", required = false) @RequestParam(required = false) Integer modelId,
			@ApiParam(name = "tfcardId", value = "TF卡id", required = false) @RequestParam(required = false) Integer tfcardId,
			@ApiParam(name = "token", value = "设备口令", required = false) @RequestParam(required = false) String token,
			@ApiParam(name = "expirationTime", value = "口令过期过期时间", required = false) @RequestParam(required = false) Integer expirationTime) {
		Device device = new Device(serialNumber, downloads, configId, applicationId, localId, modelId, tfcardId, token, expirationTime);
		deviceService.save(device);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ApiOperation(value = "删除设备信息", notes = "修改设备信息")
	public void delete(@ApiParam(name = "id", value = "设备信息id", required = true) @PathVariable("id") Integer id) {
		deviceService.delete(id);
	}

}
