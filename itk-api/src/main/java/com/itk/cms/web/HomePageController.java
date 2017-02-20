package com.itk.cms.web;

import com.itk.cms.model.HomePage;
import com.itk.cms.service.HomePageServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by enchen on 2/20/17.
 */

@RestController
@RequestMapping(value = "/homePage")
public class HomePageController {

    @Autowired
    HomePageServiceImpl homePageService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public WebResult addHomePage(@RequestBody HomePage homePage) throws Exception{
        try{
            return  WebResult.ok(homePageService.addHomePage(homePage));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public WebResult updateHomePage(@RequestBody HomePage homePage) throws Exception{
        try{
            return  WebResult.ok(homePageService.updateHomePage(homePage));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/{homePageID}", method = RequestMethod.DELETE)
    public WebResult deleteHomePage(@PathVariable Long homePageID){
        try{
            return  WebResult.ok(homePageService.deleteHomePage(homePageID));
        }catch (Exception e){
            return WebResult.ok(e.getMessage());
        }
    }
}
