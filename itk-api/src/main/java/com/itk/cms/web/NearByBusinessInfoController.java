package com.itk.cms.web;

import com.itk.cms.model.NearbyBusinessInfo;
import com.itk.cms.service.NearByBusinessInfoFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/cms/nearByBusiness/info")
public class NearByBusinessInfoController {

    @Autowired
    private NearByBusinessInfoFrontServiceImpl nearByBusinessInfoFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addNearbyBusinessInfo(@RequestBody NearbyBusinessInfo nearbyBusinessInfo) throws Exception{
        if(nearByBusinessInfoFrontService.addNearByBusinessInfo(nearbyBusinessInfo) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateNearbyBusinessInfo(@RequestBody NearbyBusinessInfo nearbyBusinessInfo) throws Exception {
        if(nearByBusinessInfoFrontService.updateNearByBusinessInfo(nearbyBusinessInfo) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{nearbyBusinessInfoId}", method = RequestMethod.DELETE)
    public WebResult delNearbyBusinessInfo(@PathVariable(value = "nearbyBusinessInfoId") Long nearbyBusinessInfoId) throws Exception {
        if(nearByBusinessInfoFrontService.delNearByBusinessInfo(nearbyBusinessInfoId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{nearbyBusinessInfoId}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "nearbyBusinessInfoId") Long nearbyBusinessInfoId) throws Exception {
        return WebResult.ok(nearByBusinessInfoFrontService.selectByPrimaryKey(nearbyBusinessInfoId));
    }
}
