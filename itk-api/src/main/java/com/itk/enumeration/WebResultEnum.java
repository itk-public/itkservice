package com.itk.enumeration;


/**
 * Created by enchen on 5/14/17.
 */
public enum WebResultEnum implements SysEnum {

    USERNAME_EXIST(1001),   //用户名存在
    EMAIL_EXIST(1002),      //邮箱存在
    PHONE_EXIST(1003)      //手机号存在
    ;

    private Integer id;

    WebResultEnum(Integer id){
        this.id = id;
    }

    public static WebResultEnum parse(Integer id) {
        for (WebResultEnum webResultEnumEnum : WebResultEnum.values()) {
            if (webResultEnumEnum.getID().equals(id)) {
                return webResultEnumEnum;
            }
        }
        return null;
    }

    @Override
    public Integer getID() {
        return this.id;
    }
}
