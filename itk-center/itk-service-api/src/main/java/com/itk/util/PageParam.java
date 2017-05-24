package com.itk.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author qi.yang
 * @since 2017-05-17 14:24
 */
@Getter
@Setter
@Builder
public class PageParam implements Serializable{
	/**
	 * 页码，从1开始
	 */
	private Integer pageNum;

	/**
	 * 页面大小
	 */
	private Integer pageSize;

	/**
	 * 包含count查询
	 */
	private Boolean count;

	/**
	 * 排序
	 */
	private String orderBy;

	/**
	 * 分页合理化
	 */
	private Boolean reasonable;

	/**
	 * 当设置为true的时候，如果pagesize设置为0（或RowBounds的limit=0），就不执行分页，返回全部结果
	 */
	private Boolean pageSizeZero;
}
