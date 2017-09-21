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

import com.dnp.attend.model.Model;
import com.dnp.attend.service.ModelService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 型号信息 前端控制器
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "ModelController", description = "型号信息")
@RestController
@RequestMapping(value = "/model", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModelController {

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有型号信息", notes = "查询所有型号信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        Model model = new Model();
        return modelService.selectByExample(pageVo, search, "", model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询型号信息详情", notes = "查询型号信息详情", httpMethod = "GET")
    public Model findById(@ApiParam(name = "id", value = "型号信息id", required = true) @PathVariable("id") Integer id) {
        return modelService.selectByKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改型号信息", notes = "修改型号信息")
    public void update(Model model) {
        modelService.updateAll(model);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加型号信息", notes = "添加型号信息")
    public void save(@ApiParam(name = "name", value = "型号名称", required = false) @RequestParam(required = false) String name) {
        Model model = new Model(name);
        modelService.save(model);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除型号信息", notes = "修改型号信息")
    public void delete(@ApiParam(name = "id", value = "型号信息id", required = true) @PathVariable("id") Integer id) {
        modelService.delete(id);
    }

}
