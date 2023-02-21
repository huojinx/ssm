package com.ssmtest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssmtest.pojo.Category;
import com.ssmtest.service.CategoryService;
import com.ssmtest.util.Page;
/*
 * 列表查询
 * 单个查询
 * update修改 edit编辑
 * 删除
 * 增加
 */
@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	//用来处理json提交
	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接受到浏览器提交的json，并转换为Category对象："+category);
		return "ok";
	}
	
	//json获取单个对象
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory() {
		Category c = new Category();
		c.setId(100);
		c.setName("第120个分类");
		JSONObject json = new JSONObject();
		json.put("category",JSONObject.toJSON(c));
		return json.toJSONString();
	}
	
	//json获取多个对象
	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(i);
			c.setName("分类名称："+i);
			cs.add(c);
		}
		return JSONObject.toJSON(cs).toString();
	}
	
	@RequestMapping("listCategory")  //现在使用的是pagehelper插件，用于分页。
	public ModelAndView listCategory(Page page) {
		ModelAndView mav = new ModelAndView();
//		PageHelper.offsetPage(page.getStart(), 10);
		List<Category> cs = categoryService.list(page);
//		List<Category> cs = categoryService.list();
		int total = categoryService.total();
//		int total = (int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		//如果该页面是末页，那么下一页就是末页
//		if(cs.isEmpty()) {
//			page.setStart(page.getLast());
//			cs = categoryService.list(page);
//		}
				
		mav.addObject("cs",cs);
		//放入jsp路径
		//设置此ModelAndView的视图名称，
		//由DispatcherServlet 通过 ViewResolver解析。
		mav.setViewName("listCategory");   
		return mav;
	}
	
	@RequestMapping("deleteCategory")
	public ModelAndView deleteCategory(Category category) {
		
		categoryService.delete(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}
	
	@RequestMapping("editCategory")
	public ModelAndView editCategory(int id) {
		Category category = categoryService.get(id);
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("category",category);
		return mav;
	}
	
	@RequestMapping("updateCategory")
	public ModelAndView updateCategory(Category category) {
		categoryService.update(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}
	
	@RequestMapping("addCategory")
	public ModelAndView addCategory(Category category) {
		categoryService.add(category);
		ModelAndView mav = new ModelAndView("redirect:/listCategory");
		return mav;
	}

}
