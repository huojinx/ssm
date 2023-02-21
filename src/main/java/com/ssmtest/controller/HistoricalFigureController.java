package com.ssmtest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssmtest.pojo.Category;
import com.ssmtest.pojo.HistoricalFigure;
import com.ssmtest.service.CategoryService;
import com.ssmtest.service.HistoricalFigureService;
import com.ssmtest.service.impl.HistoricalFigureServiceImpl;
import com.ssmtest.util.Page;
/*
 * 
 * 可以考虑显示所有品种的列表
 * 
 * 如何处理分类和品种之间的关系？
 * 点击分类，可以看到具体的品种，sql语句使用分类的id筛选。
 */
@Controller
@RequestMapping("")
public class HistoricalFigureController {

	@Autowired
	HistoricalFigureService historicalFigureService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("listHistoricalFigure")
	public ModelAndView listHistoricalFigure(Category category,Page page) {
		System.out.println(category);
//		if(category.getId()!=0) {
//			category = categoryService.get(category.getId());
//			System.out.println(category);
//		}
		category = categoryService.get(category.getId());
		System.out.println(category);
		
		Map<String,Object> m = new HashMap();
		m.put("category", category);
		m.put("page", page);
		
		List<HistoricalFigure> hs = historicalFigureService.list(m);
		int total = historicalFigureService.total(category);
		page.caculateLast(total);
		
		ModelAndView mav = new ModelAndView("listHistoricalFigure");
		mav.addObject("category",category);
		mav.addObject("hs",hs);
		return mav;
	}
	
	@RequestMapping("addHistoricalFigure")
	public ModelAndView addHistoricalFigure(HistoricalFigure historicalFigure) {
		historicalFigureService.add(historicalFigure);
		ModelAndView mav = new ModelAndView("redirect:/listHistoricalFigure?id="+historicalFigure.getCategory().getId());
		return mav;
	}
	
	@RequestMapping("deleteHistoricalFigure")
	public ModelAndView deleteHistoricalFigure(HistoricalFigure historicalFigure) {
		historicalFigure = historicalFigureService.get(historicalFigure.getId());  //为了后面使用historicalFigure的category的id
		historicalFigureService.delete(historicalFigure);
		ModelAndView mav = new ModelAndView("redirect:/listHistoricalFigure?id="+historicalFigure.getCategory().getId());
		return mav;
	}
	
	@RequestMapping("editHistoricalFigure")
	public ModelAndView editHistoricalFigure(int id) {
		HistoricalFigure h = historicalFigureService.get(id);
		ModelAndView mav = new ModelAndView("editHistoricalFigure");
		mav.addObject("historicalfigure",h);
		return mav;
	}
	
	@RequestMapping("updateHistoricalFigure")
	public ModelAndView updateHistoricalFigure(HistoricalFigure historicalFigure) {
		historicalFigureService.update(historicalFigure);
		ModelAndView mav = new ModelAndView("redirect:/listHistoricalFigure?id="+historicalFigure.getCategory().getId());
		return mav;
	}
}
