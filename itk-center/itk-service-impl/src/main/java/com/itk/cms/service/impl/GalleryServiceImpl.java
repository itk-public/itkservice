package com.itk.cms.service.impl;

import com.itk.cms.mapper.GalleryMapper;
import com.itk.cms.model.Gallery;
import com.itk.cms.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryMapper galleryMapper;


    @Override
    public int addGallery(Gallery gallery) {
        return galleryMapper.insertSelective(gallery);
    }

    @Override
    public int updateGallery(Gallery gallery) {
        return galleryMapper.updateByPrimaryKeySelective(gallery);
    }



    @Override
    public int delGallery(Gallery gallery) {
        gallery.setIsDel(1);
        return galleryMapper.updateByPrimaryKeySelective(gallery);
    }

    @Override
    public Gallery selectByPrimaryKey(Long id) {
        return galleryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Gallery> selectGallerysByPageSortId(Integer pageSortId) {
        return galleryMapper.selectGallerysByPageSortId(pageSortId);
    }
}
