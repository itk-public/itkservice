package com.itk.base.web;

import com.itk.base.service.PositionTownFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enchen on 2/23/17.
 */
@RestController
@RequestMapping("/base/position/town")
public class PositionTownController {

    @Autowired
    private PositionTownFrontServiceImpl positionTownFrontService;

    @RequestMapping(value = "/selectTownByCountyId/{CountyId}", method = RequestMethod.GET)
    public WebResult selectTownByCountyId(@PathVariable(value = "CountyId") Long countyId) throws Exception {
        return WebResult.ok(positionTownFrontService.selectTownByCountyId(countyId));
    }

    @RequestMapping(value = "/selectTownByTownId/{townId}", method = RequestMethod.GET)
    public WebResult selectTownByTownId(@PathVariable(value = "townId") Long townId) throws Exception {
        return WebResult.ok(positionTownFrontService.selectTownByTownId(townId));
    }
}
