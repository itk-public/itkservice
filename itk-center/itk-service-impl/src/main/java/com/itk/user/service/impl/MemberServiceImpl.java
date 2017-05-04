package com.itk.user.service.impl;

import com.itk.user.mapper.MemberMapper;
import com.itk.user.model.Member;
import com.itk.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by enchen on 5/4/17.
 */
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public int addMember(Member member) {
        return memberMapper.insertSelective(member);
    }

    @Override
    public int updateMember(Member member) {
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public int delMember(Integer id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        member.setIsDel(0);//0 不可用, 1 可用
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Member selectByUserId(Long userId) {
        return memberMapper.selectByUserId(userId);
    }

    @Override
    public Member selectByPrimaryKey(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
