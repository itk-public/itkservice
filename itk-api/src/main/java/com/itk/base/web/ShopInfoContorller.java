package com.itk.base.web;

import com.itk.base.service.ShopInfoFrontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouhui on 2017/3/3.
 */
@RestController
@RequestMapping("/base/shopinfo")
public class ShopInfoContorller {

    @Autowired
    private ShopInfoFrontServiceImpl shopInfoFrontService;


}
