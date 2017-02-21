package com.itk.cms.web;

import com.itk.cms.model.Skupos;
import com.itk.cms.service.SkuposFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhouhui on 2017/2/21.
 */
@RestController
@RequestMapping("/cms/skupos")
public class SkuposController {

    @Autowired
    private SkuposFrontServiceImpl skuposFrontService;

    @RequestMapping(value = "/addSkupos", method = RequestMethod.GET)
    public WebResult addSkupos(@RequestParam("homePageId")Integer pageSortId, @RequestParam("name")String name,
                               @RequestParam("src")String src, @RequestParam("action")String action,
                               @RequestParam("position")Long position,
                               @RequestParam("productId")Long productId) throws Exception {
        Skupos skupos = new Skupos();
        skupos.setPageSortId(pageSortId);
        skupos.setName(name);
        skupos.setSrc(src);
        skupos.setAction(action);
        skupos.setPosition(position);
        skupos.setProductId(productId);
        skupos.setCreateTime(new Date());
        skupos.setIsDel(0);
        if(skuposFrontService.addSkupos(skupos) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/updateSkupos/{id}", method = RequestMethod.GET)
    public WebResult updateSkupos(@PathVariable(value = "id") Long id, @RequestParam("homePageId")Integer pageSortId,
                                  @RequestParam("name")String name, @RequestParam("src")String src, @RequestParam("action")String action,
                                  @RequestParam("position")Long position,
                                  @RequestParam("productId")Long productId) throws Exception {
        Skupos skupos = new Skupos();
        skupos.setId(id);
        skupos.setPageSortId(pageSortId);
        skupos.setName(name);
        skupos.setSrc(src);
        skupos.setAction(action);
        skupos.setPosition(position);
        skupos.setProductId(productId);
        if(skuposFrontService.updateSkupos(skupos) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/delSkupos/{id}", method = RequestMethod.GET)
    public WebResult delSkupos(@PathVariable(value = "id") Long id) throws Exception {
        Skupos skupos = new Skupos();
        skupos.setId(id);
        skupos.setIsDel(1);
        if(skuposFrontService.delSkupos(skupos) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }

    @RequestMapping(value = "/selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public WebResult selectByPrimaryKey(@PathVariable(value = "id") Long id) throws Exception {
        return WebResult.ok(skuposFrontService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/selectSkupossByPageSortId", method = RequestMethod.GET)
    public WebResult selectSkupossByPageSortId(@RequestParam("pageSortId")Long pageSortId) throws Exception {
        return WebResult.ok(skuposFrontService.selectSkupossByPageSortId(pageSortId));
    }


}
