package com.ssmtest.pojo;
/*
 * 新建对应的historicalfigure类
 * 要和category建立一对多
 * 和多对一的关系
 * 要新建对应的mapper和xml，
 * 对应的service
 * 和controller
 * 视图方面，考虑category和historicalfigures的关系，
 * 怎样点击category查看对应的historiesfigures,怎样显示historiesfigures时显示category,
 * 添加historiesfigures时要选择类。
 * 有以前的案例，可以看看。
 */
public class HistoricalFigure {

	public HistoricalFigure() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private String year;
	private String achievement;
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	
	@Override
	public String toString() {
		return "HistoricalFigure [id="+getId()+" name="+getName()+" year="+getYear()+" ]";
	}
}
