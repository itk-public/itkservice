package com.itk.util;

/**
 * Created by young on 2017/5/24.
 */
public final class ResultCode {

    /**
     * com.itk.exception message id , 与 i18n 文件中 key 对应
     */

    public static final String UNKNOW_ERROR = "UNKNOW ERROR";

    public static final String UNKNOW_SOURCE = "UNKNOW SOURCE";

    //请求成功
    public static final int SUCCESS = 0;

    public static final int NOT_FOUND = 404;    //找不到对象

    public static final int ADD_SUCCESS = 201;  //添加成功

    public static final int EDIT_SUCCESS = 202; //修改成功

    public static final int DELETE_SUCCESS = 203;   //删除成功


    //用户相关错误
    public static final int USERNAME_EXIST = 1001;    //用户名已存在
    public static final int EMAIL_EXIST = 1002;    //邮箱已存在
    public static final int PHONE_EXIST = 1003;    //手机号已存在

    //biz attribute not null error
    public static final int PICK_SELF_LOCATION_ID = 2001;
    public static final int ORDER_ID_REQUIRED = 2002;

    //退货相关业务错误
    public static final int REFUND_STATUS_ERROR = 3001;         //退款订单状态不符
    public static final int REFUND_ORDER_UNKNOWN = 3002;         //订单编号未知,退款流程异常
    public static final int REFUND_ORDER_DETAIL_UNKNOWN = 3003;         //订单详情未知,退款流程异常
    public static final int REFUND_REASON_REQUIRED = 3004;         //退款理由必填
    public static final int OPERATOR_INVALID = 3005;         //操作人不符
    public static final int REFUND_ADDRESS_REQUIRED = 3006;         //收货地址必填
    public static final int REFUND_REJECT_REASON = 3007;         //驳回理由必填
    public static final int REFUND_FLOW_ID_REQUIRED = 3008;         //退款单号必填
    public static final int REFUND_EXPRESS_COMPANY_REQUIRED = 3009;         //快递公司
    public static final int REFUND_EXPRESS_NO_REQUIRED = 3010;         //物流单号
    public static final int REFUND_REJECT_RECEIVED_REASON = 3011;         //收货后驳回理由必填

    //系统错误
    public static final int SYSTEM_ERROR = 5001;       //系统内部错误
}
