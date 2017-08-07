package com.itk.item.service.impl;

import com.itk.item.convert.ItemCommentMapper;
import com.itk.item.model.ItemComment;
import com.itk.item.service.ItemCommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public class ItemCommentServiceImpl implements ItemCommentService {

    @Autowired
    private ItemCommentMapper itemCommentMapper;

    @Override
    public int addItemComment(ItemComment itemComment) {
        return itemCommentMapper.insertSelective(itemComment);
    }

    @Override
    public int updateItemComment(ItemComment itemComment) {
        return itemCommentMapper.updateByPrimaryKeySelective(itemComment);
    }

    @Override
    public int delItemComment(Integer id) {
        ItemComment itemComment = itemCommentMapper.selectByPrimaryKey(id);
        itemComment.setStatus(0);
        return itemCommentMapper.updateByPrimaryKeySelective(itemComment);
    }

    @Override
    public ItemComment selectByPrimaryKey(Integer id) {
        return itemCommentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ItemComment> selectByItemId(String itemId) {
        return itemCommentMapper.selectByItemId(itemId);
    }
}
