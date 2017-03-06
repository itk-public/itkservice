package com.itk.cms.service;

import com.itk.cms.model.Skupos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
@Service
public class SkuposFrontServiceImpl {

    @Autowired
    private SkuposService skuposService;

    public int addSkupos(Skupos skupos){
        return  skuposService.addSkupos(skupos);
    }

    public int updateSkupos(Skupos skupos){
        return  skuposService.updateSkupos(skupos);
    }

    public int delSkupos(Skupos skupos){
        return  skuposService.delSkupos(skupos);
    }

    public Skupos selectByPrimaryKey(Long id){
        return  skuposService.selectByPrimaryKey(id);
    }

    public List<Skupos> selectSkupossByPageSortId(Integer pageSortId){
        return  skuposService.selectSkupossByPageSortId(pageSortId);
    }
}
