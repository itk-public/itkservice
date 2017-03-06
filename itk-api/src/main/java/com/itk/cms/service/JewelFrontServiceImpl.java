package com.itk.cms.service;

import com.itk.cms.model.Jewel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
@Service
public class JewelFrontServiceImpl {

    @Autowired
    private JewelService jewelService;

    public int addJewel(Jewel jewel){
        return jewelService.addJewel(jewel);
    }

    public int updateJewel(Jewel jewel){
        return jewelService.updateJewel(jewel);
    }

    public int delJewel(Jewel jewel){
        return jewelService.updateJewel(jewel);
    }

    public Jewel selectByPrimaryKey(Long id){
        return jewelService.selectByPrimaryKey(id);
    }

    public List<Jewel> selectJewelsByPageSortId(Integer pageSortId){
        return jewelService.selectJewelsByPageSortId(pageSortId);
    }
}
