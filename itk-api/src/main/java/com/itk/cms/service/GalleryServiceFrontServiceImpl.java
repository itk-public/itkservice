package com.itk.cms.service;

import com.itk.cms.model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
@Service
public class GalleryServiceFrontServiceImpl {

    @Autowired
    private GalleryService galleryService;

    public int addGallery(Gallery gallery){
        return galleryService.addGallery(gallery);
    }

    public int updateGallery(Gallery gallery){
        return galleryService.updateGallery(gallery);
    }

    public int deleGallery(Gallery gallery){
       return galleryService.deleGallery(gallery);
    }

    public Gallery selectByPrimaryKey(Long id){
        return galleryService.selectByPrimaryKey(id);
    }

    public List<Gallery> selectGallerysByPageSortId(Long pageSortId){
        return galleryService.selectGallerysByPageSortId(pageSortId);
    }

}
