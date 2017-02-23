package com.itk.cms.service;

import com.itk.cms.model.Hbanner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by enchen on 2/21/17.
 */
@Service
public class HbannerFrontServiceImpl {

    @Autowired
    private HbannerService hbannerService;

    public int addHbanner(Hbanner hbanner){
        return hbannerService.addHbanner(hbanner);
    }

    public int updateHbanner(Hbanner hbanner){
        return hbannerService.updateHbanner(hbanner);
    }

    public int delHbanner(Long hbannerID){
        return hbannerService.delHbanner(hbannerID);
    }

    public Hbanner selectByPrimaryKey(Long hbannerID){
        return hbannerService.selectByPrimaryKey(hbannerID);
    }

    public List<Hbanner> selectHbannersByPageSortId(Long pageSortId){
        return hbannerService.selectHbannersByPageSortId(pageSortId);
    }
}
