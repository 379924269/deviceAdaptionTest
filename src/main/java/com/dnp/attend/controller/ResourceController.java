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

import com.dnp.attend.model.Resource;
import com.dnp.attend.service.ResourceService;
import com.dnp.attend.vo.PageVo;

/**
 * 资源权限信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Api(value = "ResourceController", description = "资源权限信息")
@RestController
@RequestMapping(value = "/resource", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有资源权限信息", notes = "查询所有资源权限信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询资源权限信息详情", notes = "查询资源权限信息详情", httpMethod = "GET")
    public Resource findById(@ApiParam(name = "id", value = "资源权限信息id", required = true) @PathVariable("id") Integer id) {
        return resourceService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改资源权限信息", notes = "修改资源权限信息")
    public void update(Resource resource) {
        resourceService.updateAll(resource);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加资源权限信息", notes = "添加资源权限信息")
    public void save(

            @ApiParam(name = "name", value = "资源权限信息")
            @RequestParam(required = false, name = "name") String name
            ,
            @ApiParam(name = "parentId", value = "资源权限信息")
            @RequestParam(required = false, name = "parentId") Integer parentId
            ,
            @ApiParam(name = "resKey", value = "资源权限信息")
            @RequestParam(required = false, name = "resKey") String resKey
            ,
            @ApiParam(name = "resUrl", value = "资源权限信息")
            @RequestParam(required = false, name = "resUrl") String resUrl
    ) {
        Resource resource = new Resource(

                name, parentId, resKey, resUrl);
        resourceService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除资源权限信息", notes = "修改资源权限信息")
    public void delete(@ApiParam(name = "id", value = "资源权限信息id", required = true) @PathVariable("id") Integer id) {
        resourceService.delete(id);
    }

}
