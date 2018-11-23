package com.lh.common.utils;

import java.util.List;

/**
 * @author LH李恒
 * @date 创建时间：2018年10月22日 下午4:06:50
 * @param <T>
 */
public class Page<T> {
    
	private int total;
	private int page;
	private int size;
    private List<T> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    @Override
    public String toString() {
        return "Page [total=" + total + ", page=" + page + ", size=" + size + ", rows=" + rows + "]";
    }
     
}