package com.mtech.hel.web;


import com.mtech.hel.entity.Help;
import com.mtech.hel.service.HelpService;

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
@RequestMapping("/hel/help")
public class HelpController{
	
	
	@Autowired
	private HelpService helpService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helpSave(){
		return "hel/help/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helpSave(Help help) {
		helpService.save(help);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helpView(@RequestParam("id") String id,Model model){
		Help help = helpService.get(id);
		model.addAttribute("help", help);
		return "hel/help/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helpEdit(@RequestParam("id") String id,Model model){
		Help help = helpService.get(id);
		model.addAttribute("help", help);
		return "hel/help/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helpEdit(Help help){
		 helpService.update(help);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helpDelete(@RequestParam("id") String id){
		 helpService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helpList(){
		return "hel/help/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<Help> helpList(Searchable searchable)  {
		Page<Help> result = helpService.findAll(searchable);
		return result;
	}

}