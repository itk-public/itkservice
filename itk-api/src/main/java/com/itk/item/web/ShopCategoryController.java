package com.itk.item.web;

import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ShopCategory;
import com.itk.item.service.DisplayCategoryFrontServiceImpl;
import com.itk.item.service.ShopCategoryFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/item/shopCategory")
public class ShopCategoryController {

    @Autowired
    private ShopCategoryFrontServiceImpl shopCategoryFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addShopCategory(@RequestBody ShopCategory shopCategory) throws Exception{
        if(shopCategoryFrontService.addShopCategory(shopCategory) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateShopCategory(@RequestBody ShopCategory shopCategory) throws Exception {
        if(shopCategoryFrontService.updateShopCategory(shopCategory) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delete/{shopCategoryId}", method = RequestMethod.DELETE)
    public WebResult delShopCategory(@PathVariable(value = "shopCategoryId") Integer displayCategoryId) throws Exception {
        if(shopCategoryFrontService.delShopCategory(displayCategoryId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectShopCategories", method = RequestMethod.GET)
    public WebResult selectShopCategories() throws Exception {
        return WebResult.ok(shopCategoryFrontService.selectShopCategories());
    }

    @RequestMapping(value = "/selectShopCategoryDetail/{shopCategoryId}", method = RequestMethod.GET)
    public WebResult selectDisplayCategoriesByParentId(@PathVariable(value = "shopCategoryId") Integer shopCategoryId) throws Exception {
        return WebResult.ok(shopCategoryFrontService.selectByPrimaryKey(shopCategoryId));
    }
}
