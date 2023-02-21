package com.ssmtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssmtest.mapper.CategoryMapper;
import com.ssmtest.pojo.Category;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryMapper categoryMapper;
	
	public List<Category> list(){
		return categoryMapper.list();
	}
	
	@Override
	public List<Category> list(Page page){
		return categoryMapper.list(page);
	}
	
	@Override
	public int total() {
		return categoryMapper.total();
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return  categoryMapper.get(id);
	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.delete(category.getId());
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.update(category);
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryMapper.add(category);
	}

	@Override
	public void deleteAll() {
		Page page = new Page();
		page.setStart(40);
		List<Category> cs = list(page);
		for(Category c:cs) {
			categoryMapper.delete(c.getId());
		}
	
	}
	
	@Override
	//配置事务管理
	@Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
	public void addTwo() {
		Category c1 = new Category();
		c1.setName("短的名字");
		categoryMapper.add(c1);
		
		Category c2 = new Category();
		c2.setName("名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下，名字长对应字段放不下");
		categoryMapper.add(c2);
	}
}
