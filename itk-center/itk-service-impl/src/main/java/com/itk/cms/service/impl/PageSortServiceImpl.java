package com.itk.cms.service.impl;

import com.itk.cms.mapper.PageSortMapper;
import com.itk.cms.model.PageSort;
import com.itk.cms.service.PageSortService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
public class PageSortServiceImpl implements PageSortService {

    @Autowired
    private PageSortMapper pageSortMapper;


    @Override
    public int addPageSort(PageSort pageSort) {
        return pageSortMapper.insertSelective(pageSort);
    }

    @Override
    public List<PageSort> selectPageSortsByHomePageId(Long homePageId) {
        return pageSortMapper.selectPageSortsByHomePageId(homePageId);
    }


}
