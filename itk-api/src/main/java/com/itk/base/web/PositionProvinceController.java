package com.itk.base.web;

import com.itk.base.service.PositionProvinceServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/base/position/province")
public class PositionProvinceController {

    @Autowired
    private PositionProvinceServiceImpl provinceService;

    @RequestMapping(value = "/select/all", method = RequestMethod.GET)
    public WebResult selectAllProvince() throws Exception {
        return WebResult.ok(provinceService.selectAllProvince());
    }

    @RequestMapping(value = "/selectProvinceByProvinceId/{provinceId}", method = RequestMethod.GET)
    public WebResult selectProvinceByProvinceId(@PathVariable(value = "provinceId") Long provinceId) throws Exception {
        return WebResult.ok(provinceService.selectProvinceByProvinceId(provinceId));
    }
}
