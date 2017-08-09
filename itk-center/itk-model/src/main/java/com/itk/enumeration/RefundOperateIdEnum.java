package com.itk.enumeration;

/**
 * Created by enchen on 8/9/17.
 */
public enum RefundOperateIdEnum implements SysEnum {
    SUBMIT(1001),                               //提交申请
    WITHDRAW(1002),                             //撤回申请
    BUSINESS_PASS(1003),                        //商家通过申请
    BUSINESS_REJECT(1004),                      //商家驳回申请
    SHIP_CONFIRM(1005),                         //确认发货
    RECEIVE_CONFIRM(1006),                      //确认收货
    BUSINESS_REJECT_WITH_COMMODITY(1007),       //商家收货后驳回
    START_PAY_BACK(1008),                       //发起退款
    DONE_PAY_BACK(1009)                         //确认付款
    ;

    private Integer id;

    RefundOperateIdEnum(Integer id) {
        this.id = id;
    }

    public static RefundOperateIdEnum parse(Integer id) {
        for (RefundOperateIdEnum fieldType : RefundOperateIdEnum.values()) {
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
