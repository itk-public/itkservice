package com.itk.base.web;

import com.itk.base.service.PositionVillageFrontServiceImpl;
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
public class PositionVillageController {

    @Autowired
    private PositionVillageFrontServiceImpl positionVillageFrontService;

    @RequestMapping(value = "/selectVillageByTownId/{townId}", method = RequestMethod.GET)
    public WebResult selectVillageByTownId(@PathVariable(value = "townId") Long townId) throws Exception {
        return WebResult.ok(positionVillageFrontService.selectVillageByTownId(townId));
    }

    @RequestMapping(value = "/selectTownByTownId/{villageId}", method = RequestMethod.GET)
    public WebResult selectVillageByVillageId(@PathVariable(value = "villageId") Long villageId) throws Exception {
        return WebResult.ok(positionVillageFrontService.selectVillageByVillageId(villageId));
    }
}
