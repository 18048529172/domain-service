package com.liw.domain.web.helper;

public class PageEntity<T> extends ResultEntity<T>{

    private long totalPage;

    private long total;


    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
