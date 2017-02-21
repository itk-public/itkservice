package com.itk.cms.service;

import com.itk.cms.model.Partingline;

import java.util.List;

/**
 * Created by zhouhui on 2017/2/21.
 */
public interface PartinglineService {

    int addPartingline(Partingline partingline);

    int updatePartingline(Partingline partingline);

    int delPartingline(Partingline partingline);

    Partingline selectByPrimaryKey(Long id);

    List<Partingline> selectPartinglinesByPageSortId(Long pageSortId);
}
