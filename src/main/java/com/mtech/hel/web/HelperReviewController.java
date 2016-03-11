package com.mtech.hel.web;


import com.mtech.hel.entity.HelperReview;
import com.mtech.hel.service.HelperReviewService;

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
@RequestMapping("/hel/helperReview")
public class HelperReviewController{
	
	
	@Autowired
	private HelperReviewService helperReviewService;

	@RequestMapping(value="/save.html",method=RequestMethod.GET)
	public String helperReviewSave(){
		return "hel/helperReview/save";
	}
	

	@RequestMapping(value="/save.json",method=RequestMethod.POST)
	public @ResponseBody AjaxResult helperReviewSave(HelperReview helperReview) {
		helperReviewService.save(helperReview);
		return AjaxResult.suc();
	}
	
	
	@RequestMapping(value="/view.html",method=RequestMethod.GET)
	public String helperReviewView(@RequestParam("id") String id,Model model){
		HelperReview helperReview = helperReviewService.get(id);
		model.addAttribute("helperReview", helperReview);
		return "hel/helperReview/view";
	}
	
	
	@RequestMapping(value="/edit.html",method = RequestMethod.GET)
	public String helperReviewEdit(@RequestParam("id") String id,Model model){
		HelperReview helperReview = helperReviewService.get(id);
		model.addAttribute("helperReview", helperReview);
		return "hel/helperReview/edit";
	}
	
	@RequestMapping(value="/edit.json",method = RequestMethod.POST)
	public @ResponseBody  AjaxResult helperReviewEdit(HelperReview helperReview){
		 helperReviewService.update(helperReview);
		 return AjaxResult.suc();
	}
	@RequestMapping(value = "/delete.json", method = RequestMethod.GET)
	public @ResponseBody  AjaxResult helperReviewDelete(@RequestParam("id") String id){
		 helperReviewService.delete(id);
		 return AjaxResult.suc();
	}
	
	@RequestMapping(value="/list.html",method = RequestMethod.GET)
	public String helperReviewList(){
		return "hel/helperReview/list";
	}
	
	@RequestMapping(value = "/list.json", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Page<HelperReview> helperReviewList(Searchable searchable)  {
		Page<HelperReview> result = helperReviewService.findAll(searchable);
		return result;
	}

}