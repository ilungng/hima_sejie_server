package com.hima.sejie.dao;

import java.util.ArrayList;
import java.util.List;

public class CutPageBean {
	private int total;
	@Override
	public String toString() {
		return "CutPageBean [total=" + total + ", rows=" + rows
				+ ", getRows()=" + getRows() + ", getTotal()=" + getTotal()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	private List rows = new ArrayList();
	
	public CutPageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CutPageBean(List rows, int total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	
	
}
