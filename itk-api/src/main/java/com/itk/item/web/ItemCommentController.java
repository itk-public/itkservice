package com.itk.item.web;

import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ItemComment;
import com.itk.item.service.DisplayCategoryFrontServiceImpl;
import com.itk.item.service.ItemCommentFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/item/itemComment")
public class ItemCommentController {

    @Autowired
    private ItemCommentFrontServiceImpl itemCommentFrontService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addItemComment(@RequestBody ItemComment itemComment) throws Exception{
        if(itemCommentFrontService.addItemComment(itemComment) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateItemComment(@RequestBody ItemComment itemComment) throws Exception {
        if(itemCommentFrontService.updateItemComment(itemComment) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/deleteItemComment/{itemCommentId}", method = RequestMethod.DELETE)
    public WebResult delItemComment(@PathVariable(value = "itemCommentId") Integer itemCommentId) throws Exception {
        if(itemCommentFrontService.delItemComment(itemCommentId) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectByItemId/{itemId}", method = RequestMethod.GET)
    public WebResult selectItemCommentByItemId(@PathVariable(value = "itemId") String itemId) throws Exception {
        return WebResult.ok(itemCommentFrontService.selectItemCommentByItemId(itemId));
    }

    @RequestMapping(value = "/selectItemCommentDetail/{itemCommentId}", method = RequestMethod.GET)
    public WebResult selectItemCommentDetail(@PathVariable(value = "itemCommentId") Integer itemCommentId) throws Exception {
        return WebResult.ok(itemCommentFrontService.selectByPrimaryKey(itemCommentId));
    }
}
