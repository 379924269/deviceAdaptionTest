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

import com.dnp.attend.model.Config;
import com.dnp.attend.service.ConfigService;
import com.dnp.attend.vo.PageVo;

/**
 * 配置信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Api(value = "ConfigController", description = "配置信息")
@RestController
@RequestMapping(value = "/config", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有配置信息", notes = "查询所有配置信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询配置信息详情", notes = "查询配置信息详情", httpMethod = "GET")
    public Config findById(@ApiParam(name = "id", value = "配置信息id", required = true) @PathVariable("id") Integer id) {
        return configService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改配置信息", notes = "修改配置信息")
    public void update(Config config) {
        configService.updateAll(config);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加配置信息", notes = "添加配置信息")
    public void save(

            @ApiParam(name = "name", value = "配置信息")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "content", value = "配置信息")
            @RequestParam(required = false, name = "content") String content
            ,
            @ApiParam(name = "createdDate", value = "配置信息")
            @RequestParam(required = false, name = "createdDate") Long createdDate
            ,
            @ApiParam(name = "locationId", value = "配置信息")
            @RequestParam(required = false, name = "locationId") Integer locationId
            ,
            @ApiParam(name = "modelId", value = "配置信息")
            @RequestParam(required = false, name = "modelId") Integer modelId
    ) {
        Config config = new Config(

                name, content, createdDate, locationId, modelId);
        configService.save(config);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除配置信息", notes = "修改配置信息")
    public void delete(@ApiParam(name = "id", value = "配置信息id", required = true) @PathVariable("id") Integer id) {
        configService.delete(id);
    }

}
