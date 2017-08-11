package com.itk.payment.service.impl;

import com.itk.payment.mapper.RefundFlowMapper;
import com.itk.payment.model.RefundFlow;
import com.itk.payment.model.RefundFlowExample;
import com.itk.payment.service.RefundFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public class RefundFlowServiceImpl implements RefundFlowService {

    @Autowired
    RefundFlowMapper refundFlowMapper;

    @Transactional
    @Override
    public RefundFlow insertSelective(RefundFlow refundFlow) {
        Long id = refundFlowMapper.insertSelective(refundFlow);
        return refundFlowMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public RefundFlow updateByPrimaryKeySelective(RefundFlow refundFlow) {
        refundFlowMapper.updateByPrimaryKeySelective(refundFlow);
        return refundFlowMapper.selectByPrimaryKey(refundFlow.getId());
    }

    @Override
    public RefundFlow selectByRefundFlowId(String refundFlowId) {
        RefundFlowExample example = new RefundFlowExample();
        example.or().andFlowIdEqualTo(refundFlowId);
        List<RefundFlow> refundFlowList = refundFlowMapper.selectByExample(example);
        return refundFlowList.size() > 0 ? refundFlowList.get(0) : null;

    }

    @Override
    public RefundFlow selectByPurchaseId(String purchaseId) {
        RefundFlowExample example = new RefundFlowExample();
        example.or().andPurchaseIdEqualTo(purchaseId);
        List<RefundFlow> refundFlowList = refundFlowMapper.selectByExample(example);
        return refundFlowList.size() > 0 ? refundFlowList.get(0) : null;
    }
}
