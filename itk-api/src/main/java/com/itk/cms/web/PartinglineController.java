package com.itk.cms.web;

import com.itk.cms.model.Partingline;
import com.itk.cms.service.PartinglineFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/21.
 */
@RestController
@RequestMapping("/cms/partingline")
public class PartinglineController {

    @Autowired
    private PartinglineFrontServiceImpl partinglineFrontService;

    @RequestMapping(value = "/addPartingline", method = RequestMethod.GET)
    public WebResult addPartingline(@RequestParam("homePageId")Integer pageSortId, @RequestParam("name")String name,
                                @RequestParam("src")String src) throws Exception {
        Partingline partingline = new Partingline();
        partingline.setPageSortId(pageSortId);
        partingline.setName(name);
        partingline.setSrc(src);
        partingline.setCreateTime(new Date());
        partingline.setIsDel(0);
        if(partinglineFrontService.addPartingline(partingline) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updatePartingline/{id}", method = RequestMethod.GET)
    public WebResult updatePartingline(@PathVariable(value = "id") Long id, @RequestParam("homePageId")Integer pageSortId,@RequestParam("name")String name,
                                       @RequestParam("src")String src) throws Exception {
        Partingline partingline = new Partingline();
        partingline.setId(id);
        partingline.setPageSortId(pageSortId);
        partingline.setName(name);
        partingline.setSrc(src);
        if(partinglineFrontService.updatePartingline(partingline) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delPartingline/{id}", method = RequestMethod.GET)
    public WebResult delPartingline(@PathVariable(value = "id") Long id) throws Exception {
        Partingline Partingline = new Partingline();
        Partingline.setId(id);
        Partingline.setIsDel(1);
        if(partinglineFrontService.delPartingline(Partingline) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(partinglineFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectPartinglinesByPageSortId", method = RequestMethod.GET)
    public WebResult selectPartinglinesByPageSortId(@RequestParam("pageSortId")Integer pageSortId) throws Exception {
        return WebResult.ok(partinglineFrontService.selectPartinglinesByPageSortId(pageSortId));
    }
}
