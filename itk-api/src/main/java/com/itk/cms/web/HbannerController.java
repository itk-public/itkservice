package com.itk.cms.web;

import com.itk.cms.model.Hbanner;
import com.itk.cms.service.HbannerFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/21/17.
 */

@RestController
@RequestMapping("/cms/Hbanner")
public class HbannerController {

    @Autowired
    private HbannerFrontServiceImpl hbannerFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addHBanner(@RequestBody Hbanner hbanner) throws Exception{
        if(hbannerFrontService.addHbanner(hbanner) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateHbanner(@RequestBody Hbanner hbanner) throws Exception {
        if(hbannerFrontService.updateHbanner(hbanner) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{hbannerID}", method = RequestMethod.DELETE)
    public WebResult delGallery(@PathVariable(value = "hbannerID") Long hbannerID) throws Exception {
        if(hbannerFrontService.delHbanner(hbannerID) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{hbannerID}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "hbannerID") Long hbannerID) throws Exception {
        return WebResult.ok(hbannerFrontService.selectByPrimaryKey(hbannerID));
    }

    @RequestMapping(value = "/selectHbannersByPageSortId", method = RequestMethod.GET)
    public WebResult selectGallerysByPageSortId(@RequestParam("pageSortId")Integer pageSortId) throws Exception {
        return WebResult.ok(hbannerFrontService.selectHbannersByPageSortId(pageSortId));
    }
}
