package com.itk.cms.service;

import com.itk.cms.model.PageSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/20.
 */
@Service
public class HomePageSortFrontServiceImpl {

    @Autowired
    private PageSortService pageSortService;


    public int addPageSort(PageSort pageSort){
        return pageSortService.addPageSort(pageSort);
    }

    public List<PageSort> selectPageSortsByHomePageId(Long homePageId){
        return pageSortService.selectPageSortsByHomePageId(homePageId);
    }

}
