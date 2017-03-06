package com.itk.cms.web;

import com.itk.cms.model.Seckill;
import com.itk.cms.service.SeckillFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/21.
 */
@RestController
@RequestMapping("/cms/seckill")
public class SeckillController {

    @Autowired
    private SeckillFrontServiceImpl seckillFrontService;

    @RequestMapping(value = "/addSeckill", method = RequestMethod.GET)
    public WebResult addSeckill(@RequestParam("homePageId")Integer pageSortId,@RequestParam("seasonId")Long seasonId,
                                @RequestParam("priority")Long priority, @RequestParam("productId")Long productId) throws Exception {
        Seckill seckill = new Seckill();
        seckill.setPageSortId(pageSortId);
        seckill.setPriority(priority);
        seckill.setSeasonId(seasonId);
        seckill.setProductId(productId);
        seckill.setCreateTime(new Date());
        seckill.setIsDel(0);
        if(seckillFrontService.addSeckill(seckill) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateSeckill/{id}", method = RequestMethod.GET)
    public WebResult updateSeckill(@PathVariable(value = "id") Long id, @RequestParam("homePageId")Integer pageSortId,
                                   @RequestParam("seasonId")Long seasonId,
                                   @RequestParam("priority")Long priority, @RequestParam("productId")Long productId) throws Exception {
        Seckill seckill = new Seckill();
        seckill.setId(id);
        seckill.setPageSortId(pageSortId);
        seckill.setPriority(priority);
        seckill.setSeasonId(seasonId);
        seckill.setProductId(productId);
        if(seckillFrontService.updateSeckill(seckill) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delSeckill/{id}", method = RequestMethod.GET)
    public WebResult delSeckill(@PathVariable(value = "id") Long id) throws Exception {
        Seckill seckill = new Seckill();
        seckill.setId(id);
        seckill.setIsDel(1);
        if(seckillFrontService.delSeckill(seckill) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(seckillFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectSeckillsByPageSortId", method = RequestMethod.GET)
    public WebResult selectSeckillsByPageSortId(@RequestParam("pageSortId")Integer pageSortId) throws Exception {
        return WebResult.ok(seckillFrontService.selectSeckillsByPageSortId(pageSortId));
    }


}
