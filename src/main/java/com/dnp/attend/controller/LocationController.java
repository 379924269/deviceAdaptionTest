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

import com.dnp.attend.model.Location;
import com.dnp.attend.service.LocationService;
import com.dnp.attend.vo.PageVo;

/**
 * 归属地信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Api(value = "LocationController", description = "归属地信息")
@RestController
@RequestMapping(value = "/location", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有归属地信息", notes = "查询所有归属地信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询归属地信息详情", notes = "查询归属地信息详情", httpMethod = "GET")
    public Location findById(@ApiParam(name = "id", value = "归属地信息id", required = true) @PathVariable("id") Integer id) {
        return locationService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改归属地信息", notes = "修改归属地信息")
    public void update(Location location) {
        locationService.updateAll(location);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加归属地信息", notes = "添加归属地信息")
    public void save(

            @ApiParam(name = "name", value = "归属地信息")
            @RequestParam(required = false, name = "name") String name
    ) {
        Location location = new Location(

                name);
        locationService.save(location);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除归属地信息", notes = "修改归属地信息")
    public void delete(@ApiParam(name = "id", value = "归属地信息id", required = true) @PathVariable("id") Integer id) {
        locationService.delete(id);
    }

}
