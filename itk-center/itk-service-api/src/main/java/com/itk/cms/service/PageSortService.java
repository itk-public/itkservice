package com.itk.cms.service;

import com.itk.cms.model.PageSort;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
public interface PageSortService {

    int addPageSort(PageSort pageSort);

    List<PageSort> selectPageSortsByHomePageId(Long homePageId);

}
