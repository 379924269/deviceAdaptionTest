package com.dnp.attend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dnp.attend.commons.base.BaseController;
import com.dnp.attend.model.User;
import com.dnp.attend.service.UserService;
import com.dnp.attend.vo.PageVo;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author huaxing.xie
 * @since 2017-06-08
 */
@Api(value = "UserController", description = "用户信息")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        System.out.println(request.getSession().getId());
        User user = new User();
        return userService.selectByExample(pageVo, search, "", user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息详情", notes = "查询用户信息详情", httpMethod = "GET")
    public User findById(@ApiParam(name = "id", value = "用户信息id", required = true) @PathVariable("id") Integer id) {
        return userService.selectByKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public Object update(User user) {
        userService.updateNotNull(user);
        return renderSuccess();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    public Object save(@ApiParam(name = "name", value = "用户名称", required = false) @RequestParam(required = false) String name,
                       @ApiParam(name = "email", value = "用户email", required = false) @RequestParam(required = false) String email,
                       @ApiParam(name = "password", value = "用户密码", required = false) @RequestParam(required = false) String password,
                       @ApiParam(name = "createdDate", value = "用户创建日期", required = false) @RequestParam(required = false) Date createdDate,
                       @ApiParam(name = "roleId", value = "角色id", required = false) @RequestParam(required = false) Integer roleId) {
        User user = new User(name, email, password, createdDate, roleId);
        userService.save(user);
        return renderSuccess();
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户信息", notes = "修改用户信息")
    public Object delete(@ApiParam(name = "id", value = "用户信息id", required = true) @PathVariable("id") Integer id) {
        userService.delete(id);
        renderSuccess();
        return renderSuccess();
    }
}
