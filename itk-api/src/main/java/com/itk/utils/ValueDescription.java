package com.itk.utils;

/**
 * 实现一个可以读取value和description表述的枚举对应的接口，此处value不同于name
 */
public interface ValueDescription {
    /**
     * @return 获取枚举的值，不同于name()
     */
    String getValue();

    /**
     * @return 获得枚举的表述文字
     */
    String getDescription();
}