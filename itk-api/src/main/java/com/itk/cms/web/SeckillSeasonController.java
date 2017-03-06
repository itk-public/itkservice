package com.itk.cms.web;

import com.itk.cms.model.SeckillSeason;
import com.itk.cms.service.SeckillSeasonFrontService;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/21.
 */
@RestController
@RequestMapping("/cms/seckillseason")
public class SeckillSeasonController {

    @Autowired
    private SeckillSeasonFrontService seckillSeasonFrontService;

    @RequestMapping(value = "/addSeckillSeason", method = RequestMethod.GET)
    public WebResult addSeckillSeason(@RequestParam("name")String name,@RequestParam("seasonTime")Date seasonTime) throws Exception {
        SeckillSeason seckillSeason = new SeckillSeason();
        seckillSeason.setName(name);
        seckillSeason.setSeasonTime(seasonTime);
        seckillSeason.setCreateTime(new Date());
        seckillSeason.setIsDel(0);
        if(seckillSeasonFrontService.addSeckillSeason(seckillSeason) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateSeckill/{id}", method = RequestMethod.GET)
    public WebResult updateSeckill(@PathVariable(value = "id") Long id, @RequestParam("name")String name,
                                   @RequestParam("seasonTime")Date seasonTime) throws Exception {
        SeckillSeason seckillSeason = new SeckillSeason();
        seckillSeason.setId(id);
        seckillSeason.setName(name);
        seckillSeason.setSeasonTime(seasonTime);
        if(seckillSeasonFrontService.updateSeckillSeason(seckillSeason) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delSeckillSeason/{id}", method = RequestMethod.GET)
    public WebResult delSeckillSeason(@PathVariable(value = "id") Long id) throws Exception {
        SeckillSeason seckillSeason = new SeckillSeason();
        seckillSeason.setId(id);
        seckillSeason.setIsDel(1);
        if(seckillSeasonFrontService.delSeckillSeason(seckillSeason) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(seckillSeasonFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectSeckillSeasons", method = RequestMethod.GET)
    public WebResult selectSeckillSeasons() throws Exception {
        return WebResult.ok(seckillSeasonFrontService.selectSeckillSeasons());
    }


}
