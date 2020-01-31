package com.ask.entity;

import java.io.Serializable;

public class BudgetInfo implements Serializable{
	
	private int id;
	private String contents;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
