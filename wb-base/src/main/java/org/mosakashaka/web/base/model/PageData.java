package org.mosakashaka.web.base.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageData<E> {
    private int pageNum;
    private int pageSize;
    private long startRow;
    private long endRow;
    private long total;
    private int pages;
    private List<E> rows;

    public  PageData<E> from(List<E> list) {
        return from(new PageInfo<E>(list));
    }

    public PageData<E> from(com.github.pagehelper.PageInfo<E> page) {
        PageData pageInfo = new PageData();

        pageInfo.setPageNum(page.getPageNum());

        pageInfo.setPageSize(page.getPageSize());

        pageInfo.setRows(page.getList());

        pageInfo.setStartRow(page.getStartRow());

        pageInfo.setEndRow(page.getEndRow());

        pageInfo.setPages(page.getPages());

        pageInfo.setTotal(page.getTotal());

        return pageInfo;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getStartRow() {
        return this.startRow;
    }

    public long getEndRow() {
        return this.endRow;
    }

    public long getTotal() {
        return this.total;
    }

    public int getPages() {
        return this.pages;
    }

    public List<E> getRows() {
        return this.rows;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public void setEndRow(long endRow) {
        this.endRow = endRow;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PageData)) return false;
        PageData other = (PageData) o;
        if (!other.canEqual(this)) return false;
        if (getPageNum() != other.getPageNum()) return false;
        if (getPageSize() != other.getPageSize()) return false;
        if (getStartRow() != other.getStartRow()) return false;
        if (getEndRow() != other.getEndRow()) return false;
        if (getTotal() != other.getTotal()) return false;
        if (getPages() != other.getPages()) return false;
        Object this$rows = getRows();
        Object other$rows = other.getRows();
        return this$rows == null ? other$rows == null : this$rows.equals(other$rows);
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageData;
    }

    public int hashCode() {
        int PRIME = 59;
        long result = 1;
        result = result * 59 + getPageNum();
        result = result * 59 + getPageSize();
        result = result * 59 + getStartRow();
        result = result * 59 + getEndRow();
        long $total = getTotal();
        result = result * 59 + (int) ($total >>> 32 ^ $total);
        result = result * 59 + getPages();
        Object $rows = getRows();
        return (int)result * 59 + ($rows == null ? 43 : $rows.hashCode());
    }

    public String toString() {
        return "PageInfo(pageNum=" + getPageNum() + ", pageSize=" + getPageSize() + ", startRow=" + getStartRow() + ", endRow=" + getEndRow() + ", total=" + getTotal() + ", pages=" + getPages() + ", rows=" + getRows() + ")";
    }
}
