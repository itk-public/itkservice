package com.itk.user.web;

import com.itk.user.model.Member;
import com.itk.user.service.MemberFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Created by enchen on 5/4/17.
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberFrontServiceImpl memberFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addMember(@RequestBody Member member) throws Exception{
        member.setMemberId(UUID.randomUUID().toString());
        member.setCreateDate(new Date());
        if(memberFrontService.addMember(member) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public WebResult updateMember(@RequestBody Member member) throws Exception {
        if(memberFrontService.updateMember(member) > 0){
            return WebResult.ok("修改成功！");
        }
        return WebResult.ok("修改失败！");
    }

    @RequestMapping(value = "/deleteMember/{id}", method = RequestMethod.DELETE)
    public WebResult delMember(@PathVariable(value = "id") Integer id) throws Exception {
        if(memberFrontService.delMember(id) > 0){
            return WebResult.ok("删除成功！");
        }
        return WebResult.ok("删除失败！");
    }


    @RequestMapping(value = "/selectMemberByUserId/{userId}", method = RequestMethod.GET)
    public WebResult selectMemberByUserId(@PathVariable(value = "userId") Long userId) throws Exception {
        return WebResult.ok(memberFrontService.selectByUserId(userId));
    }

    @RequestMapping(value = "/selectById/{id}", method = RequestMethod.GET)
    public WebResult selectById(@PathVariable(value = "id") Integer id) throws Exception {
        return WebResult.ok(memberFrontService.selectByPrimaryKey(id));
    }
}
