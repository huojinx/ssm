package com.ssmtest.service;

import java.util.List;

import com.ssmtest.pojo.Category;
import com.ssmtest.util.Page;

public interface CategoryService {
	
	List<Category> list();
	
	int total();
	
	List<Category> list(Page page);
	
	Category get(int id);
	
	void delete(Category category);
	
	void update(Category category);
	
	void add(Category category);
	
	
	void addTwo();
	
	void deleteAll();
}
