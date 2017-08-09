package com.itk.enumeration;

/**
 * Created by enchen on 8/9/17.
 */

/**
 * 1002,1003,1004 三种状态下,可撤回
 */
public enum RefundStatusEnum implements SysEnum {
    SUBMIT(1001),                           //提交
    WITHDRAW(1002),                         //已撤销(初态)
    BUSINESS_REJECT(1003),                  //商家驳回申请(初态)
    WAIT_SHIP(1004),                        //待邮寄
    WAIT_RECEIVE_CONFIRM(2001),             //已寄出,待收货
    RECEIVED_COMMODITY_WAIT_DEAL(2002),     //已收货,待商品审核
    BUSINESS_REJECT_WITH_COMMODITY(2003),   //商家收货后最终驳回(初态)
    WAIT_PAY_BACK(2004),                    //发起退款,退款中
    DONE(3001)                              //退款已完成(终态)
    ;

    private Integer id;

    RefundStatusEnum(Integer id){
        this.id = id;
    }

    public static RefundStatusEnum parse(Integer id) {
        for (RefundStatusEnum fieldType : RefundStatusEnum.values()) {
            if (fieldType.getID().equals(id)) {
                return fieldType;
            }
        }
        return null;
    }

    @Override
    public Integer getID() {
        return null;
    }
}
