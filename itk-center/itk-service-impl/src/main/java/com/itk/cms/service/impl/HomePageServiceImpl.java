package com.itk.cms.service.impl;

import com.itk.cms.mapper.HomePageMapper;
import com.itk.cms.model.HomePage;
import com.itk.cms.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by enchen on 2/20/17.
 */
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    HomePageMapper homePageMapper;

    @Override
    public int addHomePage(HomePage homePage) throws Exception {
        return homePageMapper.insertSelective(homePage);
    }

    @Override
    public int updateHomePage(HomePage homePage) throws Exception {
        return homePageMapper.updateByPrimaryKeySelective(homePage);
    }

    @Override
    public int deleteHomePage(Long homePageID) throws Exception {
        HomePage homePage = homePageMapper.selectByPrimaryKey(homePageID);
        homePage.setIsDel(1);// isDel 0: 可用  1: 已删除
        return homePageMapper.updateByPrimaryKeySelective(homePage);
    }

    @Override
    public List<HomePage> selectHomePages() {
        return homePageMapper.selectHomePages();
    }
}
