package com.itk.base.web;

import com.itk.base.service.PositionCityFrontServiceImpl;
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
@RequestMapping("/base/position/city")
public class PositionCityController {

    @Autowired
    private PositionCityFrontServiceImpl positionCityFrontService;

    @RequestMapping(value = "/selectCityByProvinceId/{provinceId}", method = RequestMethod.GET)
    public WebResult selectCityByProvinceId(@PathVariable(value = "provinceId")Integer provinceId) throws Exception {
        return WebResult.ok(positionCityFrontService.selectCityByProvinceId(provinceId));
    }

    @RequestMapping(value = "/selectCityByCityId/{cityId}", method = RequestMethod.GET)
    public WebResult selectCityByCityId(@PathVariable(value = "cityId") Long cityId) throws Exception {
        return WebResult.ok(positionCityFrontService.selectCityByCityId(cityId));
    }
}
