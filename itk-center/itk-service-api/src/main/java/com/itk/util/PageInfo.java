package com.itk.util;

import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by young on 2017/5/24.
 */
@Setter
@Getter
@NoArgsConstructor
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private int startRow;
    private int endRow;
    private long total;
    private int pages;
    private boolean count;
    private Boolean countSignal;
    private String orderBy;
    private boolean orderByOnly;
    private Boolean reasonable;
    private Boolean pageSizeZero;
    private List<T> result;

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，而出现一些问题。
     *
     * @param list page结果
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.startRow = page.getStartRow();
            this.endRow = page.getEndRow();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.count = page.isCount();
            this.countSignal = page.getCountSignal();
            this.orderBy = page.getOrderBy();
            this.orderByOnly = page.isOrderByOnly();
            this.reasonable = page.getReasonable();
            this.pageSizeZero = page.getPageSizeZero();
            this.result = page.getResult();
        }
    }

    public PageInfo(org.springframework.data.domain.Page<T> page) {
        this.result = page.getContent();
        this.pageNum = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.total = page.getTotalElements();
        this.pages = page.getTotalPages();
        this.count = true;
    }
}
