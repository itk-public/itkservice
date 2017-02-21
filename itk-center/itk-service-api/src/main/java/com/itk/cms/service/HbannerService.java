package com.itk.cms.service;

import com.itk.cms.model.Hbanner;

import java.util.List;


/**
 * Created by enchen on 2/21/17.
 */
public interface HbannerService {

    int addHbanner(Hbanner hbanner);

    int updateHbanner(Hbanner hbanner);

    int delHbanner(Long HbannerID);

    Hbanner selectByPrimaryKey(Long id);

    List<Hbanner> selectHbannersByPageSortId(Long pageSortId);
}
