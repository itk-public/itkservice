package com.itk.cms.web;

import com.itk.cms.model.HomePage;
import com.itk.cms.service.HomePageFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by enchen on 2/20/17.
 */

@RestController
@RequestMapping(value = "/cms/homePage")
public class HomePageController {

    @Autowired
    HomePageFrontServiceImpl homePageService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public WebResult addHomePage(@RequestBody HomePage homePage) throws Exception{
        try{
            if(homePageService.addHomePage(homePage)>0){
                return  WebResult.ok("添加成功！");
            }
            return  WebResult.ok("添加失败！");
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResult updateHomePage(@RequestBody HomePage homePage) throws Exception{
        try{
            if(homePageService.updateHomePage(homePage)>0){
                return  WebResult.ok("修改成功！");
            }
            return  WebResult.ok("修改失败！");
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/{homePageID}", method = RequestMethod.DELETE)
    public WebResult deleteHomePage(@PathVariable Long homePageID){
        try{
            if(homePageService.deleteHomePage(homePageID)>0){
                return  WebResult.ok("删除成功！");
            }
            return  WebResult.ok("删除失败！");
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }
}
