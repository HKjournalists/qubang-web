package com.mtech.hel.web;


import com.mtech.hel.entity.Helper;
import com.mtech.hel.service.HelperService;

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
@RequestMapping("/hel/helper")
public class HelperController{
	
	
	@Autowired
	private HelperService helperService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helperSave(){
		return "hel/helper/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helperSave(Helper helper) {
		helperService.save(helper);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helperView(@RequestParam("id") String id,Model model){
		Helper helper = helperService.get(id);
		model.addAttribute("helper", helper);
		return "hel/helper/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helperEdit(@RequestParam("id") String id,Model model){
		Helper helper = helperService.get(id);
		model.addAttribute("helper", helper);
		return "hel/helper/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helperEdit(Helper helper){
		 helperService.update(helper);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helperDelete(@RequestParam("id") String id){
		 helperService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helperList(){
		return "hel/helper/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<Helper> helperList(Searchable searchable)  {
		Page<Helper> result = helperService.findAll(searchable);
		return result;
	}

}