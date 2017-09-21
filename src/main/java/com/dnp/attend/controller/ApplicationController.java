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
 * 应用信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
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
        return applicationService.selectByExample(pageVo, search, "name", new Application());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询应用信息详情", notes = "查询应用信息详情", httpMethod = "GET")
    public Application findById(@ApiParam(name = "id", value = "应用信息id", required = true) @PathVariable("id") Integer id) {
        return applicationService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改应用信息", notes = "修改应用信息")
    public void update(Application application) {
        applicationService.updateAll(application);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加应用信息", notes = "添加应用信息")
    public void save(@ApiParam(name = "name", value = "应用信息", required = true)
                     @RequestParam(name = "name") String name, @ApiParam(name = "versionName", value = "应用信息")
                     @RequestParam(required = false, name = "versionName") String versionName, @ApiParam(name = "versionCode", value = "应用信息", required = true)
                     @RequestParam(name = "versionCode") Integer versionCode, @ApiParam(name = "packageName", value = "应用信息")
                     @RequestParam(required = false, name = "packageName") String packageName, @ApiParam(name = "system", value = "应用信息")
                     @RequestParam(required = false, name = "system") String system, @ApiParam(name = "md5", value = "应用信息")
                     @RequestParam(required = false, name = "md5") String md5, @ApiParam(name = "size", value = "应用信息")
                     @RequestParam(required = false, name = "size") Integer size, @ApiParam(name = "url", value = "应用信息", required = true)
                     @RequestParam(name = "url") String url, @ApiParam(name = "createdDate", value = "应用信息", required = true)
                     @RequestParam(name = "createdDate") Long createdDate, @ApiParam(name = "description", value = "应用信息")
                     @RequestParam(required = false, name = "description") String description
    ) {
        Application application = new Application(name, versionName, versionCode, packageName, system, md5, size, url, createdDate, description);
        applicationService.save(application);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除应用信息", notes = "修改应用信息")
    public void delete(@ApiParam(name = "id", value = "应用信息id", required = true) @PathVariable("id") Integer id) {
        applicationService.delete(id);
    }

}
