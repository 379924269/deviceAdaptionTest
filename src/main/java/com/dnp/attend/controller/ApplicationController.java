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

import com.dnp.attend.model.Application;
import com.dnp.attend.service.ApplicationService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 应用信息 前端控制器
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "ApplicationController", description = "应用信息")
@RestController
@RequestMapping(value = "/application", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有应用信息", notes = "查询所有应用信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        Application application = new Application();
        return applicationService.selectByExample(pageVo, search, "", application);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询应用信息详情", notes = "查询应用信息详情", httpMethod = "GET")
    public Application findById(@ApiParam(name = "id", value = "应用信息id", required = true) @PathVariable("id") Integer id) {
        return applicationService.selectByKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改应用信息", notes = "修改应用信息")
    public void update(Application application) {
        applicationService.updateAll(application);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加应用信息", notes = "添加应用信息")
    public void save(@ApiParam(name = "name", value = "应用名称", required = false) @RequestParam(required = false) String name,
                     @ApiParam(name = "versionName", value = "应用版本名称", required = false) @RequestParam(required = false) String versionName,
                     @ApiParam(name = "versionCode", value = "应用版本号", required = false) @RequestParam(required = false) String versionCode,
                     @ApiParam(name = "packageName", value = "应用报名", required = false) @RequestParam(required = false) String packageName,
                     @ApiParam(name = "system", value = "应用版本：如：华为、中心等（包名相同不同版本）", required = false) @RequestParam(required = false) String system,
                     @ApiParam(name = "md5", value = "应用MD5", required = false) @RequestParam(required = false) String md5,
                     @ApiParam(name = "size", value = "应用大小", required = false) @RequestParam(required = false) Integer size,
                     @ApiParam(name = "url", value = "应用地址", required = false) @RequestParam(required = false) String url) {
        Application application = new Application(name, versionName, versionCode, packageName, system, md5, size, url);
        applicationService.save(application);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除应用信息", notes = "修改应用信息")
    public void delete(@ApiParam(name = "id", value = "应用信息id", required = true) @PathVariable("id") Integer id) {
        applicationService.delete(id);
    }

}
