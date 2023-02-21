package com.ssmtest.service;

import java.util.List;
import java.util.Map;

import com.ssmtest.pojo.Category;
import com.ssmtest.pojo.HistoricalFigure;
import com.ssmtest.util.Page;

public interface HistoricalFigureService {
	List<HistoricalFigure> list(Map m);
	
	int total(Category c);
	
	HistoricalFigure get(int id);
	
	void delete(HistoricalFigure historicalFigure);
	
	void update(HistoricalFigure historicalFigure);
	
	void add(HistoricalFigure historicalFigure);

}
