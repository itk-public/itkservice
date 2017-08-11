package com.itk.payment.web;

import com.itk.payment.convert.RefundInfoConvert;
import com.itk.payment.model.RefundInfoVO;
import com.itk.payment.service.RefundFrontServiceImpl;
import com.itk.util.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by enchen on 5/5/17.
 */
@RestController
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    RefundFrontServiceImpl refundFrontService;

    /**
     * 提交退款
     *
     * @param refundInfoVO
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public WebResult submitRefund(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.submitRefund(refundInfoVO)
                )
        );
    }

    /**
     * 撤回退款单
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/withdraw/{flowId}", method = RequestMethod.POST)
    public WebResult submitRefund(@PathVariable(value = "flowId") String flowId) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.withdrawRefund(flowId)
                )
        );
    }

    /**
     * 商家通过退款单
     *
     * @param refundInfoVO
     * @return
     */
    @RequestMapping(value = "/businessPassRefund", method = RequestMethod.POST)
    public WebResult businessPassRefund(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.businessPassRefund(refundInfoVO)
                )
        );
    }

    /**
     * 商家驳回退款单
     *
     * @param refundInfoVO
     * @return
     */
    @RequestMapping(value = "/businessRejectRefund", method = RequestMethod.POST)
    public WebResult businessRejectRefund(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.businessRejectRefund(refundInfoVO)
                )
        );
    }

    /**
     * 用户确认发货
     *
     * @param refundInfoVO
     * @return
     */
    @RequestMapping(value = "/shipConfirm", method = RequestMethod.POST)
    public WebResult customerShipConfirm(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.customerShipConfirm(refundInfoVO)
                )
        );
    }

    /**
     * 商家确认收货
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/businessReceivedConfirm/{flowId}", method = RequestMethod.POST)
    public WebResult businessReceivedConfirm(@PathVariable(value = "flowId") String flowId) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.businessReceivedConfirm(flowId)
                )
        );
    }

    /**
     * 商家确认收货后驳回退款单
     *
     * @param refundInfoVO
     * @return
     */
    @RequestMapping(value = "/businessRejectWithCommodity", method = RequestMethod.POST)
    public WebResult businessRejectWithCommodity(@RequestBody RefundInfoVO refundInfoVO) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.businessRejectWithCommodity(refundInfoVO)
                )
        );
    }

    /**
     * 商家发起退款
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/businessStartPayBack/{flowId}", method = RequestMethod.POST)
    public WebResult businessStartPayBack(@PathVariable(value = "flowId") String flowId) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.businessStartPayBack(flowId)
                )
        );
    }

    /**
     * 支付系统退款完成,回写状态
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/businessStartPayBack/{flowId}/{operatorId}", method = RequestMethod.POST)
    public WebResult completeRefundPayBack(@PathVariable(value = "flowId") String flowId,
                                           @PathVariable(value = "operatorId") Integer operatorId) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.completeRefundPayBack(flowId, operatorId)
                )
        );
    }

    /**
     * 根据 flowId 查找退款单详情
     *
     * @param flowId
     * @return
     */
    @RequestMapping(value = "/selectByFlowId/{flowId}", method = RequestMethod.GET)
    public WebResult selectByFlowId(@PathVariable(value = "flowId") String flowId) {
        return WebResult.ok(
                RefundInfoConvert.RefundInfoDTOToVO(
                        refundFrontService.selectRefundInfoByFlowId(flowId)
                )
        );
    }
}
