package com.ssmtest.pojo;
/*
 * �½���Ӧ��historicalfigure��
 * Ҫ��category����һ�Զ�
 * �Ͷ��һ�Ĺ�ϵ
 * Ҫ�½���Ӧ��mapper��xml��
 * ��Ӧ��service
 * ��controller
 * ��ͼ���棬����category��historicalfigures�Ĺ�ϵ��
 * �������category�鿴��Ӧ��historiesfigures,������ʾhistoriesfiguresʱ��ʾcategory,
 * ���historiesfiguresʱҪѡ���ࡣ
 * ����ǰ�İ��������Կ�����
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
