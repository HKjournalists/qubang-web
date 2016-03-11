package com.mtech.usr.web;


import com.mtech.usr.entity.UserHelpFavorite;
import com.mtech.usr.service.UserHelpFavoriteService;

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
 * 常用帮助收藏管理Controller
 * @author code generator
 * @date 2016-03-01
 */
@Controller
@RequestMapping("/usr/userHelpFavorite")
public class UserHelpFavoriteController{
	
	
	@Autowired
	private UserHelpFavoriteService userHelpFavoriteService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String userHelpFavoriteSave(){
		return "usr/userHelpFavorite/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult userHelpFavoriteSave(UserHelpFavorite userHelpFavorite) {
		userHelpFavoriteService.save(userHelpFavorite);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String userHelpFavoriteView(@RequestParam("id") String id,Model model){
		UserHelpFavorite userHelpFavorite = userHelpFavoriteService.get(id);
		model.addAttribute("userHelpFavorite", userHelpFavorite);
		return "usr/userHelpFavorite/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String userHelpFavoriteEdit(@RequestParam("id") String id,Model model){
		UserHelpFavorite userHelpFavorite = userHelpFavoriteService.get(id);
		model.addAttribute("userHelpFavorite", userHelpFavorite);
		return "usr/userHelpFavorite/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult userHelpFavoriteEdit(UserHelpFavorite userHelpFavorite){
		 userHelpFavoriteService.update(userHelpFavorite);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult userHelpFavoriteDelete(@RequestParam("id") String id){
		 userHelpFavoriteService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String userHelpFavoriteList(){
		return "usr/userHelpFavorite/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<UserHelpFavorite> userHelpFavoriteList(Searchable searchable)  {
		Page<UserHelpFavorite> result = userHelpFavoriteService.findAll(searchable);
		return result;
	}

}