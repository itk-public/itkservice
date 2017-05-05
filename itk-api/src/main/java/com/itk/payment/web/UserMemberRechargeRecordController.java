package com.itk.payment.web;

import com.itk.payment.model.UserMemberRechargeRecord;
import com.itk.payment.service.UserMemberRechargeRecordFrontServiceImpl;
import com.itk.utils.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by enchen on 5/5/17.
 */
@Controller
@RequestMapping("/member/recharge/record")
public class UserMemberRechargeRecordController {

    @Autowired
    UserMemberRechargeRecordFrontServiceImpl userMemberRechargeRecordFrontService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public WebResult addMember(@RequestBody UserMemberRechargeRecord userMemberRechargeRecord) throws Exception{
        userMemberRechargeRecord.setCreateDate(new Date());
        if(userMemberRechargeRecordFrontService.addUserMemberRechargeRecord(userMemberRechargeRecord) > 0){
            return WebResult.ok("添加成功！");
        }
        return WebResult.ok("添加失败！");
    }

    @RequestMapping(value = "/selectBy/{memberId}", method = RequestMethod.GET)
    public WebResult selectByMemberId(@PathVariable(value = "memberId") String memberId) throws Exception {
        return WebResult.ok(userMemberRechargeRecordFrontService.selectByMemberId(memberId));
    }
}
