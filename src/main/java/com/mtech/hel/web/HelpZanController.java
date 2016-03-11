package com.mtech.hel.web;


import com.mtech.hel.entity.HelpZan;
import com.mtech.hel.service.HelpZanService;

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
@RequestMapping("/hel/helpZan")
public class HelpZanController{
	
	
	@Autowired
	private HelpZanService helpZanService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helpZanSave(){
		return "hel/helpZan/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helpZanSave(HelpZan helpZan) {
		helpZanService.save(helpZan);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helpZanView(@RequestParam("id") String id,Model model){
		HelpZan helpZan = helpZanService.get(id);
		model.addAttribute("helpZan", helpZan);
		return "hel/helpZan/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helpZanEdit(@RequestParam("id") String id,Model model){
		HelpZan helpZan = helpZanService.get(id);
		model.addAttribute("helpZan", helpZan);
		return "hel/helpZan/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helpZanEdit(HelpZan helpZan){
		 helpZanService.update(helpZan);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helpZanDelete(@RequestParam("id") String id){
		 helpZanService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helpZanList(){
		return "hel/helpZan/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<HelpZan> helpZanList(Searchable searchable)  {
		Page<HelpZan> result = helpZanService.findAll(searchable);
		return result;
	}

}