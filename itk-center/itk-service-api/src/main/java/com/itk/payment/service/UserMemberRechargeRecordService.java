package com.itk.payment.service;

import com.itk.payment.model.UserMemberRechargeRecord;

import java.util.List;

/**
 * Created by enchen on 5/5/17.
 */
public interface UserMemberRechargeRecordService {

    int addUserMemberRechargeRecord(UserMemberRechargeRecord userMemberRechargeRecord);

    List<UserMemberRechargeRecord> selectByMemberId(String memberId);
}
