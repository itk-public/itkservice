package com.itk.enumeration;

/**
 * Created by enchen on 8/9/17.
 */
public enum OperatorTypeEnum implements SysEnum {
    CUSTOMER(1001),                 //普通用户
    BUSINESS_ADMIN(1002),           //B端管理员
    SYSTEM(2001),                   //系统
    ALIPAY(3001),                   //支付宝
    WEIXIN(3002),                   //微信
    UNIONPAY(3003)                  //银联
    ;

    private Integer id;

    OperatorTypeEnum(Integer id) {
        this.id = id;
    }

    public static OperatorTypeEnum parse(Integer id) {
        for (OperatorTypeEnum fieldType : OperatorTypeEnum.values()) {
            if (fieldType.getID().equals(id)) {
                return fieldType;
            }
        }
        return null;
    }

    @Override
    public Integer getID() {
        return this.id;
    }
}
