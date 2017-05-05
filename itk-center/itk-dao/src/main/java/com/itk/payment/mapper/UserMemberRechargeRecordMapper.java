package com.itk.payment.mapper;

import com.itk.payment.model.UserMemberRechargeRecord;
import com.itk.payment.model.UserMemberRechargeRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMemberRechargeRecordMapper {
    int countByExample(UserMemberRechargeRecordExample example);

    int deleteByExample(UserMemberRechargeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMemberRechargeRecord record);

    int insertSelective(UserMemberRechargeRecord record);

    List<UserMemberRechargeRecord> selectByExample(UserMemberRechargeRecordExample example);

    UserMemberRechargeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserMemberRechargeRecord record, @Param("example") UserMemberRechargeRecordExample example);

    int updateByExample(@Param("record") UserMemberRechargeRecord record, @Param("example") UserMemberRechargeRecordExample example);

    int updateByPrimaryKeySelective(UserMemberRechargeRecord record);

    int updateByPrimaryKey(UserMemberRechargeRecord record);

    List<UserMemberRechargeRecord> selectByMemberId(String memberId);
}