package com.itk.cms.service;

import com.itk.cms.model.Gallery;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
public interface GalleryService {

    int addGallery(Gallery gallery);

    int updateGallery(Gallery gallery);

    int deleGallery(Gallery gallery);

    Gallery selectByPrimaryKey(Long id);

    List<Gallery> selectGallerysByPageSortId(Long pageSortId);
}
