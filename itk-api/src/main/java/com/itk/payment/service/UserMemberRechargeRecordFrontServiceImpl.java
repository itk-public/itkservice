package com.itk.payment.service;


import com.itk.payment.model.UserMemberRechargeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
@Service
public class UserMemberRechargeRecordFrontServiceImpl {

    @Autowired
    UserMemberRechargeRecordService userMemberRechargeRecordService;

    public int addUserMemberRechargeRecord(UserMemberRechargeRecord userMemberRechargeRecord){
        return  userMemberRechargeRecordService.addUserMemberRechargeRecord(userMemberRechargeRecord);
    }

    public List<UserMemberRechargeRecord> selectByMemberId(String memberId){
        return  userMemberRechargeRecordService.selectByMemberId(memberId);
    }
}
