package com.itk.base.service;




import com.itk.base.model.PositionTown;

import java.util.List;

/**
 * Created by enchen on 2/23/17.
 */
public interface PositionTownService {

    List<PositionTown> selectTownByCountyId(Long countyId);

    PositionTown selectTownByTownId(Long townId);

}
