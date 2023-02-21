package com.ssmtest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmtest.mapper.HistoricalFigureMapper;
import com.ssmtest.pojo.Category;
import com.ssmtest.pojo.HistoricalFigure;
import com.ssmtest.service.HistoricalFigureService;
import com.ssmtest.util.Page;
@Service
public class HistoricalFigureServiceImpl implements HistoricalFigureService{

	@Autowired
	HistoricalFigureMapper historicalFigureMapper;
	
	@Override
	public List<HistoricalFigure> list(Map m){
		return historicalFigureMapper.list(m);
	}
	
	
	@Override
	public void add(HistoricalFigure historicalFigure) {
		historicalFigureMapper.add(historicalFigure);
	}
	
	@Override
	public void delete(HistoricalFigure historicalFigure) {
		historicalFigureMapper.delete(historicalFigure.getId());
	}
	
	@Override
	public void update(HistoricalFigure historicalFigure) {
		historicalFigureMapper.update(historicalFigure);
	}
	
	@Override
	public HistoricalFigure get(int id) {
		return historicalFigureMapper.getOne(id);
	}
	
	@Override
	public int total(Category c) {
		return historicalFigureMapper.total(c);
	}
}
