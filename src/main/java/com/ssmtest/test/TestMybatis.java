package com.ssmtest.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssmtest.mapper.CategoryMapper;
import com.ssmtest.mapper.HistoricalFigureMapper;
import com.ssmtest.pojo.Category;
import com.ssmtest.pojo.HistoricalFigure;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMybatis {
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private HistoricalFigureMapper historicalFigureMapper;
	
	@Autowired
	private CategoryService categoryService;

//	@Test
//	public void testAdd() {
//		for(int i = 0; i<100; i++) {
//			Category category = new Category();
//			category.setName("new Category "+i);
//			categoryMapper.add(category);
//		}
//	}
	
//	@Test
//	public void testList() {
//		System.out.println(categoryMapper);
//		List<Category> cs = categoryMapper.list();
//		for(Category c:cs) {
//			System.out.println(c);
//			List<HistoricalFigure> hs = c.getHistoricalfigures();
//			for(HistoricalFigure h:hs) {
//				System.out.println(h);
//			}
//		}
//	}
//	
//	@Test
//	public void testList2() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		Category category =new Category();
////		category.setId(7);
//		map.put("category",category);
//		Page page = new Page();
//		map.put("page", page);
//		List<HistoricalFigure> hs = historicalFigureMapper.list(map);
//		
//		System.out.println(hs.size());
//		for(HistoricalFigure h:hs) {
//			System.out.println(h+" "+h.getCategory());
//		}
//	}
	
//	@Test
//	public void testgetOne() {
//		System.out.println(
//				historicalFigureMapper.getOne(1)
//				);
//	}
	
//	@Test
//	public void total() {
//		Category category = new Category();
//		category.setId(6);
//		System.out.println(
//				historicalFigureMapper.total(category)
//				);
//	}
	
	@Test
	public void testAddTwo() {
//		categoryService.deleteAll();
		categoryService.addTwo();
	}

}
