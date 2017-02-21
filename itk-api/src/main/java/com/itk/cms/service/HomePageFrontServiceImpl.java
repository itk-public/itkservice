package com.itk.cms.service;

import com.itk.cms.model.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 2/20/17.
 */
@Service
public class HomePageFrontServiceImpl {

    @Autowired
    HomePageService homePageService;

    public int addHomePage(HomePage homePage) throws Exception{
        return homePageService.addHomePage(homePage);
    }

    public int updateHomePage(HomePage homePage) throws Exception{
        return homePageService.updateHomePage(homePage);
    }

    public int deleteHomePage(Long homePageID) throws Exception{
        return homePageService.deleteHomePage(homePageID);
    }

    public List<HomePage> selectHomePages(){
        return homePageService.selectHomePages();
    }
}