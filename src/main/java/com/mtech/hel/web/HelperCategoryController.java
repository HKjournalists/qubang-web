package com.mtech.hel.web;


import com.mtech.hel.entity.HelperCategory;
import com.mtech.hel.service.HelperCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mtech.common.entity.search.Searchable;
import com.mtech.common.web.entity.AjaxResult;

/**
 * 功能名-待添加Controller
 * @author coder generator
 * @date 2016-03-11
 */
@Controller
@RequestMapping("/hel/helperCategory")
public class HelperCategoryController{
	
	
	@Autowired
	private HelperCategoryService helperCategoryService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helperCategorySave(){
		return "hel/helperCategory/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helperCategorySave(HelperCategory helperCategory) {
		helperCategoryService.save(helperCategory);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helperCategoryView(@RequestParam("id") String id,Model model){
		HelperCategory helperCategory = helperCategoryService.get(id);
		model.addAttribute("helperCategory", helperCategory);
		return "hel/helperCategory/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helperCategoryEdit(@RequestParam("id") String id,Model model){
		HelperCategory helperCategory = helperCategoryService.get(id);
		model.addAttribute("helperCategory", helperCategory);
		return "hel/helperCategory/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helperCategoryEdit(HelperCategory helperCategory){
		 helperCategoryService.update(helperCategory);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helperCategoryDelete(@RequestParam("id") String id){
		 helperCategoryService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helperCategoryList(){
		return "hel/helperCategory/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<HelperCategory> helperCategoryList(Searchable searchable)  {
		Page<HelperCategory> result = helperCategoryService.findAll(searchable);
		return result;
	}

}