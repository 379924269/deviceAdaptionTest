package

        com.dnp.attend.controller;

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

import com.dnp.attend.model.User;
import com.dnp.attend.service.UserService;
import com.dnp.attend.vo.PageVo;

/**
 * 用户信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Api(value = "UserController", description = "用户信息")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户信息", notes = "查询所有用户信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段") @RequestParam(required = false, defaultValue = "") String search) {
        return userService.selectByExample(pageVo, search, "name", new User());
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户信息详情", notes = "查询用户信息详情", httpMethod = "GET")
    public User findById(@ApiParam(name = "id", value = "用户信息id", required = true) @PathVariable("id") Integer id) {
        return userService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    public void update(User user) {
        userService.updateAll(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    public void save(

            @ApiParam(name = "name", value = "用户信息")
            @RequestParam(name = "name") String name
            ,
            @ApiParam(name = "email", value = "用户信息")
            @RequestParam(name = "email") String email
            ,
            @ApiParam(name = "password", value = "用户信息")
            @RequestParam(name = "password") String password
            ,
            @ApiParam(name = "createdDate", value = "用户信息")
            @RequestParam(name = "createdDate") Long createdDate
            ,
            @ApiParam(name = "roleId", value = "用户信息")
            @RequestParam(name = "roleId") Integer roleId
    ) {
        User user = new User(

                name, email, password, createdDate, roleId);
        userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户信息", notes = "修改用户信息")
    public void delete(@ApiParam(name = "id", value = "用户信息id", required = true) @PathVariable("id") Integer id) {
        userService.delete(id);
    }

}
