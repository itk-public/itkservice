package com.itk.cms.web;

import com.itk.cms.model.Jewel;
import com.itk.cms.service.JewelFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/21.
 */
@RestController
@RequestMapping("/cms/jewel")
public class JewelController {
    @Autowired
    private JewelFrontServiceImpl jewelFrontService;


    @RequestMapping(value = "/addJewel", method = RequestMethod.GET)
    public WebResult addJewel(@RequestParam("homePageId")Integer pageSortId, @RequestParam("name")String name,
                              @RequestParam("src")String src, @RequestParam("action")String action,
                              @RequestParam("position")Long position, @RequestParam("onlineTime")Date onlineTime,
                              @RequestParam("offlineTime")Date offlineTime) throws Exception {
        Jewel jewel = new Jewel();
        jewel.setPageSortId(pageSortId);
        jewel.setName(name);
        jewel.setSrc(src);
        jewel.setAction(action);
        jewel.setPosition(position);
        jewel.setOnlineTime(onlineTime);
        jewel.setOfflineTime(offlineTime);
        jewel.setCreateTime(new Date());
        jewel.setIsDel(0);
        if(jewelFrontService.addJewel(jewel) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateJewel/{id}", method = RequestMethod.GET)
    public WebResult updatJewel(@PathVariable(value = "id") Long id, @RequestParam("name")String name,
                                @RequestParam("src")String src, @RequestParam("action")String action,
                                @RequestParam("position")Long position, @RequestParam("onlineTime")Date onlineTime,
                                @RequestParam("offlineTime")Date offlineTime) throws Exception {
        Jewel jewel = new Jewel();
        jewel.setId(id);
        jewel.setName(name);
        jewel.setSrc(src);
        jewel.setAction(action);
        jewel.setPosition(position);
        jewel.setOnlineTime(onlineTime);
        jewel.setOfflineTime(offlineTime);
        if(jewelFrontService.updateJewel(jewel) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/delJewel/{id}", method = RequestMethod.GET)
    public WebResult delJewel(@PathVariable(value = "id") Long id) throws Exception {
        Jewel jewel = new Jewel();
        jewel.setId(id);
        jewel.setIsDel(1);
        if(jewelFrontService.delJewel(jewel) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(jewelFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectJewelsByPageSortId", method = RequestMethod.GET)
    public WebResult selectJewelsByPageSortId(@RequestParam("pageSortId")Long pageSortId) throws Exception {
        return WebResult.ok(jewelFrontService.selectJewelsByPageSortId(pageSortId));
    }
}
