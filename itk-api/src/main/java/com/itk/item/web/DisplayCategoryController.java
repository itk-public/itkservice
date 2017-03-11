package com.itk.item.web;

import com.itk.item.model.DisplayCategory;
import com.itk.item.service.DisplayCategoryFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/cms/nearByBusiness/info")
public class DisplayCategoryController {

    @Autowired
    private DisplayCategoryFrontServiceImpl displayCategoryFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addDisplayCategory(@RequestBody DisplayCategory displayCategory) throws Exception{
        if(displayCategoryFrontService.addDisplayCategory(displayCategory) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateDisplayCategory(@RequestBody DisplayCategory displayCategory) throws Exception {
        if(displayCategoryFrontService.updateDisplayCategory(displayCategory) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{displayCategoryId}", method = RequestMethod.DELETE)
    public WebResult delNearbyBusinessInfo(@PathVariable(value = "displayCategoryId") Integer displayCategoryId) throws Exception {
        if(displayCategoryFrontService.delDisplayCategory(displayCategoryId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectDisplayCategories", method = RequestMethod.GET)
    public WebResult selectDisplayCategories() throws Exception {
        return WebResult.ok(displayCategoryFrontService.selectDisplayCategories());
    }

    @RequestMapping(value = "/selectByParentId/{parentId}", method = RequestMethod.DELETE)
    public WebResult delNearbyBusinessInfo(@PathVariable(value = "parentId") Long parentId) throws Exception {
        return WebResult.ok(displayCategoryFrontService.selectDisplayCategoriesByParentId(parentId));
    }
}
