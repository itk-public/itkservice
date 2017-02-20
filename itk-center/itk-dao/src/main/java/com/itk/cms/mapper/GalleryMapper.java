package com.itk.cms.mapper;

import com.itk.cms.model.Gallery;
import com.itk.cms.model.GalleryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GalleryMapper {
    int countByExample(GalleryExample example);

    int deleteByExample(GalleryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Gallery record);

    int insertSelective(Gallery record);

    List<Gallery> selectByExample(GalleryExample example);

    Gallery selectByPrimaryKey(Long id);

    List<Gallery> selectGallerysByPageSortId(Long pageSortId);

    int updateByExampleSelective(@Param("record") Gallery record, @Param("example") GalleryExample example);

    int updateByExample(@Param("record") Gallery record, @Param("example") GalleryExample example);

    int updateByPrimaryKeySelective(Gallery record);

    int updateByPrimaryKey(Gallery record);
}