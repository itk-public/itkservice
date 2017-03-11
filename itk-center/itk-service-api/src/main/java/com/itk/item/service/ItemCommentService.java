package com.itk.item.service;


import com.itk.item.model.ItemComment;
import com.itk.item.model.ShopCategory;

import java.util.List;

/**
 * Created by enchen on 2/21/17.
 */
public interface ItemCommentService {

    int addItemComment(ItemComment itemComment);

    int updateItemComment(ItemComment itemComment);

    int delItemComment(Integer id);

    ItemComment selectByPrimaryKey(Integer id);

    List<ItemComment> selectByItemId(String itemId);
}
