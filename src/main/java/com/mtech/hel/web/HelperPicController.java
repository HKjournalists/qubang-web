package com.mtech.hel.web;


import com.mtech.hel.entity.HelperPic;
import com.mtech.hel.service.HelperPicService;

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
@RequestMapping("/hel/helperPic")
public class HelperPicController{
	
	
	@Autowired
	private HelperPicService helperPicService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helperPicSave(){
		return "hel/helperPic/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helperPicSave(HelperPic helperPic) {
		helperPicService.save(helperPic);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helperPicView(@RequestParam("id") String id,Model model){
		HelperPic helperPic = helperPicService.get(id);
		model.addAttribute("helperPic", helperPic);
		return "hel/helperPic/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helperPicEdit(@RequestParam("id") String id,Model model){
		HelperPic helperPic = helperPicService.get(id);
		model.addAttribute("helperPic", helperPic);
		return "hel/helperPic/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helperPicEdit(HelperPic helperPic){
		 helperPicService.update(helperPic);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helperPicDelete(@RequestParam("id") String id){
		 helperPicService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helperPicList(){
		return "hel/helperPic/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<HelperPic> helperPicList(Searchable searchable)  {
		Page<HelperPic> result = helperPicService.findAll(searchable);
		return result;
	}

}