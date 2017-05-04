package com.itk.user.service;

import com.itk.user.model.Member;

/**
 * Created by enchen on 5/4/17.
 */
public interface MemberService {
    int addMember(Member member);

    int updateMember(Member member);

    int delMember(Integer id);

    Member selectByUserId(Long userId);

    Member selectByPrimaryKey(Integer id);
}
