package com.mtech.hel.web;


import com.mtech.hel.entity.HelpReply;
import com.mtech.hel.service.HelpReplyService;

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
@RequestMapping("/hel/helpReply")
public class HelpReplyController{
	
	
	@Autowired
	private HelpReplyService helpReplyService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helpReplySave(){
		return "hel/helpReply/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helpReplySave(HelpReply helpReply) {
		helpReplyService.save(helpReply);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helpReplyView(@RequestParam("id") String id,Model model){
		HelpReply helpReply = helpReplyService.get(id);
		model.addAttribute("helpReply", helpReply);
		return "hel/helpReply/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helpReplyEdit(@RequestParam("id") String id,Model model){
		HelpReply helpReply = helpReplyService.get(id);
		model.addAttribute("helpReply", helpReply);
		return "hel/helpReply/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helpReplyEdit(HelpReply helpReply){
		 helpReplyService.update(helpReply);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helpReplyDelete(@RequestParam("id") String id){
		 helpReplyService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helpReplyList(){
		return "hel/helpReply/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<HelpReply> helpReplyList(Searchable searchable)  {
		Page<HelpReply> result = helpReplyService.findAll(searchable);
		return result;
	}

}