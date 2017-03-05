package com.itk.base.web;

import com.itk.base.service.NearbyBusinessInfoFrontServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouhui on 2017/3/3.
 */
@RestController
@RequestMapping("/base/nearbybusinessinfo")
public class NearbyBusinessInfoController {

    @Autowired
    private NearbyBusinessInfoFrontServiceImpl nearbyBusinessInfoFrontService;


}
