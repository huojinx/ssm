package com.ssmtest.mapper;

import java.util.List;
import java.util.Map;

import com.ssmtest.pojo.Category;
import com.ssmtest.pojo.HistoricalFigure;

public interface HistoricalFigureMapper {
	
	
	public List<HistoricalFigure> list(Map m);
	
	public HistoricalFigure getOne(int id);

	public void add(HistoricalFigure historicalfigure);
	
	public void delete(int id);
	
	public void update(HistoricalFigure historicalFigure);
	
	public int total(Category c);
	
	

}
