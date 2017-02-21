package com.itk.cms.web;

import com.itk.cms.model.PageSort;
import com.itk.cms.service.HomePageSortFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouhui on 2017/2/20.
 */
@RestController
@RequestMapping("/cms/homepagesort")
public class HomePageSortController {

    @Autowired
    private HomePageSortFrontServiceImpl homePageSortFrontService;


    @RequestMapping(value = "/addPageSort", method = RequestMethod.GET)
    public WebResult addPageSort(@RequestParam("homePageId")Long homePageId, @RequestParam("assemblyName")String assemblyName,
                                  @RequestParam("sortId")Integer sortId) throws Exception {
        PageSort pageSort =  new PageSort();
        pageSort.setHomePageId(homePageId);
        pageSort.setAssemblyName(assemblyName);
        pageSort.setSortId(sortId);
        if(homePageSortFrontService.addPageSort(pageSort)>0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/selectPageSortsByHomePageId", method = RequestMethod.GET)
    public WebResult selectPageSortsByHomePageId(@RequestParam("homePageId")Long homePageId) throws Exception {
        return WebResult.ok(homePageSortFrontService.selectPageSortsByHomePageId(homePageId));
    }

}
