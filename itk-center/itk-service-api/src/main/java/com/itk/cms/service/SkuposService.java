package com.itk.cms.service;

import com.itk.cms.model.Skupos;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public interface SkuposService {
    int addSkupos(Skupos skupos);

    int updateSkupos(Skupos skupos);

    int delSkupos(Skupos skupos);

    Skupos selectByPrimaryKey(Long id);

    List<Skupos> selectSkupossByPageSortId(Long pageSortId);
}
