package com.bjpowernode.crm.commons.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询
 *
 * @auto admin
 * @data 2019/3/18 21:33
 */
public class PagenationVO<T> implements Serializable {

    private Long total;

    private List<T> dataList;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
