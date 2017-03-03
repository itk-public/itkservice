package com.itk.item.mapper;

import com.itk.item.model.ItemComment;
import com.itk.item.model.ItemCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemCommentMapper {
    int countByExample(ItemCommentExample example);

    int deleteByExample(ItemCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemComment record);

    int insertSelective(ItemComment record);

    List<ItemComment> selectByExample(ItemCommentExample example);

    ItemComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemComment record, @Param("example") ItemCommentExample example);

    int updateByExample(@Param("record") ItemComment record, @Param("example") ItemCommentExample example);

    int updateByPrimaryKeySelective(ItemComment record);

    int updateByPrimaryKey(ItemComment record);
}