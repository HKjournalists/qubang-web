package com.mtech.usr.web;


import com.mtech.usr.entity.User;
import com.mtech.usr.service.UserService;

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
 * 用户管理Controller
 * @author code generator
 * @date 2016-03-01
 */
@Controller
@RequestMapping("/usr/user")
public class UserController{
	
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String userSave(){
		return "usr/user/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult userSave(User user) {
		userService.save(user);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String userView(@RequestParam("id") String id,Model model){
		User user = userService.get(id);
		model.addAttribute("user", user);
		return "usr/user/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String userEdit(@RequestParam("id") String id,Model model){
		User user = userService.get(id);
		model.addAttribute("user", user);
		return "usr/user/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult userEdit(User user){
		 userService.update(user);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult userDelete(@RequestParam("id") String id){
		 userService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String userList(){
		return "usr/user/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<User> userList(Searchable searchable)  {
		Page<User> result = userService.findAll(searchable);
		return result;
	}

}