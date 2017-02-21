package com.itk.cms.service;

import com.itk.cms.model.Partingline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
@Service
public class PartinglineFrontServiceImpl {
    @Autowired
    private PartinglineService partinglineService;


    public int addPartingline(Partingline partingline){
        return partinglineService.addPartingline(partingline);
    }

    public int updatePartingline(Partingline partingline){
        return partinglineService.updatePartingline(partingline);
    }

    public int delPartingline(Partingline partingline){
        return partinglineService.delPartingline(partingline);
    }

    public Partingline selectByPrimaryKey(Long id){
        return partinglineService.selectByPrimaryKey(id);
    }

    public List<Partingline> selectPartinglinesByPageSortId(Long pageSortId){
        return partinglineService.selectPartinglinesByPageSortId(pageSortId);
    }


}
