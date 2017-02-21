package com.itk.cms.service;

import com.itk.cms.model.Jewel;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public interface JewelService {

    int addJewel(Jewel jewel);

    int updateJewel(Jewel jewel);

    int deleJewel(Jewel jewel);

    Jewel selectByPrimaryKey(Long id);

    List<Jewel> selectJewelsByPageSortId(Long pageSortId);
}
