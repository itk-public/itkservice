package com.itk.base.service;





import com.itk.base.model.PositionVillage;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public interface PositionVillageService {

    List<PositionVillage> selectVillageByTownId(Long townID);

    PositionVillage selectVillageByVillageId(Long villageId);

}
