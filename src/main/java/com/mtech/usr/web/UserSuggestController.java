package com.mtech.usr.web;


import com.mtech.usr.entity.UserSuggest;
import com.mtech.usr.service.UserSuggestService;

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
 * 用户意见管理Controller
 * @author code generator
 * @date 2016-03-01
 */
@Controller
@RequestMapping("/usr/userSuggest")
public class UserSuggestController{
	
	
	@Autowired
	private UserSuggestService userSuggestService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String userSuggestSave(){
		return "usr/userSuggest/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult userSuggestSave(UserSuggest userSuggest) {
		userSuggestService.save(userSuggest);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String userSuggestView(@RequestParam("id") String id,Model model){
		UserSuggest userSuggest = userSuggestService.get(id);
		model.addAttribute("userSuggest", userSuggest);
		return "usr/userSuggest/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String userSuggestEdit(@RequestParam("id") String id,Model model){
		UserSuggest userSuggest = userSuggestService.get(id);
		model.addAttribute("userSuggest", userSuggest);
		return "usr/userSuggest/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult userSuggestEdit(UserSuggest userSuggest){
		 userSuggestService.update(userSuggest);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult userSuggestDelete(@RequestParam("id") String id){
		 userSuggestService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String userSuggestList(){
		return "usr/userSuggest/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<UserSuggest> userSuggestList(Searchable searchable)  {
		Page<UserSuggest> result = userSuggestService.findAll(searchable);
		return result;
	}

}