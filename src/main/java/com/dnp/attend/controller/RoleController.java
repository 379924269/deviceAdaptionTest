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

import com.dnp.attend.model.Role;
import com.dnp.attend.service.RoleService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "RoleController", description = "角色信息")
@RestController
@RequestMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有角色信息", notes = "查询所有角色信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        Role role = new Role();
        return roleService.selectByExample(pageVo, search, "", role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询角色信息详情", notes = "查询角色信息详情", httpMethod = "GET")
    public Role findById(@ApiParam(name = "id", value = "角色信息id", required = true) @PathVariable("id") Integer id) {
        return roleService.selectByKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改角色信息", notes = "修改角色信息")
    public void update(Role role) {
        roleService.updateAll(role);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色信息", notes = "添加角色信息")
    public void save(@ApiParam(name = "name", value = "角色名称", required = false) @RequestParam(required = false) String name,
                     @ApiParam(name = "description", value = "角色描述", required = false) @RequestParam(required = false) String description) {
        Role role = new Role(name, description);
        roleService.save(role);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除角色信息", notes = "修改角色信息")
    public void delete(@ApiParam(name = "id", value = "角色信息id", required = true) @PathVariable("id") Integer id) {
        roleService.delete(id);
    }

}
