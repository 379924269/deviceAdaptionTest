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

import com.dnp.attend.model.Tfcard;
import com.dnp.attend.service.TfcardService;
import com.dnp.attend.vo.PageVo;

/**
 * TF卡信息  前端控制器
 *
 * @author stylefeng
 * @since 2017-09-21
 */
@Api(value = "TfcardController", description = "TF卡信息")
@RestController
@RequestMapping(value = "/tfcard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TfcardController {
    @Autowired
    private TfcardService tfcardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有TF卡信息", notes = "查询所有TF卡信息")
    public Object findAll(PageVo pageVo,
                          @ApiParam(name = "search", value = "模糊查询字段", required = false) @RequestParam(required = false, defaultValue = "") String search) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询TF卡信息详情", notes = "查询TF卡信息详情", httpMethod = "GET")
    public Tfcard findById(@ApiParam(name = "id", value = "TF卡信息id", required = true) @PathVariable("id") Integer id) {
        return tfcardService.selectByKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "修改TF卡信息", notes = "修改TF卡信息")
    public void update(Tfcard tfcard) {
        tfcardService.updateAll(tfcard);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加TF卡信息", notes = "添加TF卡信息")
    public void save(

            @ApiParam(name = "tfId", value = "TF卡信息")
            @RequestParam(required = false, name = "tfId") String tfId
            ,
            @ApiParam(name = "tfSn", value = "TF卡信息")
            @RequestParam(required = false, name = "tfSn") String tfSn
            ,
            @ApiParam(name = "status", value = "TF卡信息")
            @RequestParam(required = false, name = "status") Integer status
            ,
            @ApiParam(name = "locationId", value = "TF卡信息")
            @RequestParam(required = false, name = "locationId") Integer locationId
            ,
            @ApiParam(name = "createdDate", value = "TF卡信息")
            @RequestParam(required = false, name = "createdDate") Long createdDate
    ) {
        Tfcard tfcard = new Tfcard(

                tfId, tfSn, status, locationId, createdDate);
        tfcardService.save(tfcard);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除TF卡信息", notes = "修改TF卡信息")
    public void delete(@ApiParam(name = "id", value = "TF卡信息id", required = true) @PathVariable("id") Integer id) {
        tfcardService.delete(id);
    }

}
