package com.itk.payment.service.impl;

import com.itk.payment.mapper.UserMemberRechargeRecordMapper;
import com.itk.payment.model.UserMemberRechargeRecord;
import com.itk.payment.service.UserMemberRechargeRecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public class UserMemberRechargeRecordServiceImpl implements UserMemberRechargeRecordService {

    @Autowired
    UserMemberRechargeRecordMapper userMemberRechargeRecordMapper;

    @Override
    public int addUserMemberRechargeRecord(UserMemberRechargeRecord userMemberRechargeRecord) {
        userMemberRechargeRecord.setCreateDate(new Date());
        return userMemberRechargeRecordMapper.insertSelective(userMemberRechargeRecord);
    }

    @Override
    public List<UserMemberRechargeRecord> selectByMemberId(String memberId) {
        return userMemberRechargeRecordMapper.selectByMemberId(memberId);
    }
}
