package com.itk.user.service;

import com.itk.user.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enchen on 5/4/17.
 */
@Service
public class MemberFrontServiceImpl {

    @Autowired
    MemberService memberService;

    public int addMember(Member member){
        return  memberService.addMember(member);
    }

    public int updateMember(Member member){
        return memberService.updateMember(member);
    }

    public int delMember(Integer id){
        return memberService.delMember(id);
    }

    public Member selectByUserId(Long userId){
        return memberService.selectByUserId(userId);
    }

    public Member selectByPrimaryKey(Integer id){
        return memberService.selectByPrimaryKey(id);
    }
}
