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
 * �б��ѯ
 * ������ѯ
 * update�޸� edit�༭
 * ɾ��
 * ����
 */
@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	//��������json�ύ
	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM���ܵ�������ύ��json����ת��ΪCategory����"+category);
		return "ok";
	}
	
	//json��ȡ��������
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory() {
		Category c = new Category();
		c.setId(100);
		c.setName("��120������");
		JSONObject json = new JSONObject();
		json.put("category",JSONObject.toJSON(c));
		return json.toJSONString();
	}
	
	//json��ȡ�������
	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Category c = new Category();
			c.setId(i);
			c.setName("�������ƣ�"+i);
			cs.add(c);
		}
		return JSONObject.toJSON(cs).toString();
	}
	
	@RequestMapping("listCategory")  //����ʹ�õ���pagehelper��������ڷ�ҳ��
	public ModelAndView listCategory(Page page) {
		ModelAndView mav = new ModelAndView();
//		PageHelper.offsetPage(page.getStart(), 10);
		List<Category> cs = categoryService.list(page);
//		List<Category> cs = categoryService.list();
		int total = categoryService.total();
//		int total = (int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		//�����ҳ����ĩҳ����ô��һҳ����ĩҳ
//		if(cs.isEmpty()) {
//			page.setStart(page.getLast());
//			cs = categoryService.list(page);
//		}
				
		mav.addObject("cs",cs);
		//����jsp·��
		//���ô�ModelAndView����ͼ���ƣ�
		//��DispatcherServlet ͨ�� ViewResolver������
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
