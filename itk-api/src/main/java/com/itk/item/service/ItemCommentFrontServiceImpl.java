package com.itk.item.service;


import com.itk.item.model.DisplayCategory;
import com.itk.item.model.ItemComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class ItemCommentFrontServiceImpl {

    @Autowired
    private ItemCommentService itemCommentService;

    public int addItemComment(ItemComment itemComment){
        return itemCommentService.addItemComment(itemComment);
    }

    public int updateItemComment(ItemComment itemComment){
        return itemCommentService.updateItemComment(itemComment);
    }

    public int delItemComment(Integer itemCommentId){
        return itemCommentService.delItemComment(itemCommentId);
    }

    public ItemComment selectByPrimaryKey(Integer itemCommentId){
        return itemCommentService.selectByPrimaryKey(itemCommentId);
    }

    public List<ItemComment> selectItemCommentByItemId(String itemId){
        return itemCommentService.selectByItemId(itemId);
    }

}
