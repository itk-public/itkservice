package com.itk.cms.web;

import com.itk.cms.model.Gallery;
import com.itk.cms.service.GalleryFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/20.
 */
@RestController
@RequestMapping("/cms/gallery")
public class GalleryController {

    @Autowired
    private GalleryFrontServiceImpl galleryFrontService;


    @RequestMapping(value = "/addGallery", method = RequestMethod.GET)
    public WebResult addGallery(@RequestParam("homePageId")Integer pageSortId, @RequestParam("name")String name,
                                @RequestParam("src")String src, @RequestParam("action")String action,
                                @RequestParam("priority")Long priority, @RequestParam("onlineTime")Date onlineTime,
                                @RequestParam("offlineTime")Date offlineTime) throws Exception {
        Gallery gallery = new Gallery();
        gallery.setPageSortId(pageSortId);
        gallery.setName(name);
        gallery.setSrc(src);
        gallery.setAction(action);
        gallery.setPriority(priority);
        gallery.setOnlineTime(onlineTime);
        gallery.setOfflineTime(offlineTime);
        gallery.setCreateTime(new Date());
        gallery.setIsDel(0);
        if(galleryFrontService.addGallery(gallery) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateGallery/{id}", method = RequestMethod.GET)
    public WebResult updateGallery(@PathVariable(value = "id") Long id,@RequestParam("homePageId")Integer pageSortId,
                                   @RequestParam("name")String name,@RequestParam("src")String src, @RequestParam("action")String action,
                                   @RequestParam("priority")Long priority, @RequestParam("onlineTime")Date onlineTime,
                                   @RequestParam("offlineTime")Date offlineTime) throws Exception {
        Gallery gallery = new Gallery();
        gallery.setId(id);
        gallery.setPageSortId(pageSortId);
        gallery.setName(name);
        gallery.setSrc(src);
        gallery.setAction(action);
        gallery.setPriority(priority);
        gallery.setOnlineTime(onlineTime);
        gallery.setOfflineTime(offlineTime);
        if(galleryFrontService.updateGallery(gallery) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delGallery/{id}", method = RequestMethod.GET)
    public WebResult delGallery(@PathVariable(value = "id") Long id) throws Exception {
        Gallery gallery = new Gallery();
        gallery.setId(id);
        gallery.setIsDel(1);
        if(galleryFrontService.delGallery(gallery) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(galleryFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectGallerysByPageSortId", method = RequestMethod.GET)
    public WebResult selectGallerysByPageSortId(@RequestParam("pageSortId")Integer pageSortId) throws Exception {
        return WebResult.ok(galleryFrontService.selectGallerysByPageSortId(pageSortId));
    }


}
