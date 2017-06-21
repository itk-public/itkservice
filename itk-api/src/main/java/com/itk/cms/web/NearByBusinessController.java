package com.itk.cms.web;

import com.itk.cms.model.NearbyBusiness;
import com.itk.cms.service.NearByBusinessFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/cms/nearByBusiness")
public class NearByBusinessController {

    @Autowired
    private NearByBusinessFrontServiceImpl nearByBusinessFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addNearbyBusiness(@RequestBody NearbyBusiness nearbyBusiness) throws Exception{
        if(nearByBusinessFrontService.addNearByBusiness(nearbyBusiness) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateNearbyBusiness(@RequestBody NearbyBusiness nearbyBusiness) throws Exception {
        if(nearByBusinessFrontService.updateNearByBusiness(nearbyBusiness) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{nearbyBusinessId}", method = RequestMethod.DELETE)
    public WebResult delNearbyBusiness(@PathVariable(value = "nearbyBusinessId") Long nearbyBusinessId) throws Exception {
        if(nearByBusinessFrontService.delNearByBusiness(nearbyBusinessId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{nearbyBusinessId}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "nearbyBusinessId") Long nearbyBusinessId) throws Exception {
        return WebResult.ok(nearByBusinessFrontService.selectByPrimaryKey(nearbyBusinessId));
    }
}
