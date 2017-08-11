package com.itk.payment.service.impl;

import com.itk.payment.mapper.RefundDetailMapper;
import com.itk.payment.mapper.RefundFlowMapper;
import com.itk.payment.model.RefundDetail;
import com.itk.payment.model.RefundDetailExample;
import com.itk.payment.model.RefundFlow;
import com.itk.payment.model.RefundFlowExample;
import com.itk.payment.service.RefundDetailService;
import com.itk.payment.service.RefundFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public class RefundDetailServiceImpl implements RefundDetailService {

    @Autowired
    RefundDetailMapper refundDetailMapper;

    @Transactional
    @Override
    public RefundDetail insertSelective(RefundDetail refundDetail) {
        Long id = refundDetailMapper.insertSelective(refundDetail);
        return refundDetailMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public RefundDetail updateByPrimaryKeySelective(RefundDetail refundDetail) {
        refundDetailMapper.updateByPrimaryKeySelective(refundDetail);
        return refundDetailMapper.selectByPrimaryKey(refundDetail.getId());
    }

    @Override
    public RefundDetail selectByRefundDetailId(String refundDetailId) {
        RefundDetailExample example = new RefundDetailExample();
        example.or().andRefundDetailIdEqualTo(refundDetailId);
        List<RefundDetail> refundDetailList = refundDetailMapper.selectByExample(example);
        return refundDetailList.size() > 0 ? refundDetailList.get(0) : null;
    }

    @Override
    public RefundDetail selectByRefundFlowId(String refundFlowId) {
        RefundDetailExample example = new RefundDetailExample();
        example.or().andFlowIdEqualTo(refundFlowId);
        List<RefundDetail> refundDetailList = refundDetailMapper.selectByExample(example);
        return refundDetailList.size() > 0 ? refundDetailList.get(0) : null;
    }
}
