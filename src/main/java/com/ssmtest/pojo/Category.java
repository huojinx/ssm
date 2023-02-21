package com.ssmtest.pojo;

public class Category {

	
	private int id;
	private String name;
	private java.util.List<HistoricalFigure> historicalfigures;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.List<HistoricalFigure> getHistoricalfigures() {
		return historicalfigures;
	}
	public void setHistoricalfigures(java.util.List<HistoricalFigure> historicalfigures) {
		this.historicalfigures = historicalfigures;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
