package com.itk.cms.service;

import com.itk.cms.model.HomePage;

import java.util.List;

/**
 * Created by enchen on 2/20/17.
 */
public interface HomePageService {

    int addHomePage(HomePage homePage) throws Exception;

    int updateHomePage(HomePage homePage) throws Exception;

    int deleteHomePage(Long homePageID) throws Exception;

    List<HomePage> selectHomePages();
}
