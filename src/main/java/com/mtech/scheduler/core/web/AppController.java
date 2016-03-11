package com.mtech.scheduler.core.web;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtech.common.entity.search.Searchable;
import com.mtech.common.web.controller.BaseController;
import com.mtech.scheduler.core.entity.App;
import com.mtech.scheduler.core.service.AppService;
import com.mtech.uam.enumdata.AvailableStatus;

@Controller
@RequestMapping("/permission/app")
public class AppController extends BaseController<App, String>{
	
	private static Logger _log = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private AppService appservice;

//	@RequestMapping("/getAllApp.json")
//	public @ResponseBody  List<Tree> getAllApp(){
//		return appservice.findAllApp();
//	}
	
	/**
	 * 跳转应用新增页面
	 * @return
	 */
	@RequestMapping(value="/appSave.html",method=RequestMethod.GET)
	@RequiresPermissions("app:save")
	public String appSave(){
		_log.info("permission/app/appSave.html");
		return "uam/permission/appSave";
	}
	
	/**
	 * 保存应用
	 * @param app
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/appSave.json",method=RequestMethod.POST)
	@RequiresPermissions("app:save")
	public @ResponseBody boolean appSave(App app) throws Exception{
		appservice.createApp(app);
		_log.info("permission/app/appSave.json");
		return true;
	}
	@RequestMapping(value="/appEdit.html",method = RequestMethod.GET)
	public String appEdit(@RequestParam("id") String id,Model model){
		_log.info("permission/app/appEdit.html");
		App app = appservice.findOne(id);
		model.addAttribute("app", app);
		return "uam/permission/appEdit";
	}
	
	@RequestMapping(value="/appEdit.json",method = RequestMethod.POST)
	public @ResponseBody boolean appEdit(App app){
		appservice.updateApp(app);
		return true;
	}
	@RequestMapping(value = "/appDelete.json", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> appDelete(@RequestParam("id") String id){
		_log.info("permission/app/appDelete.json?id="+id);
		Map<String,Object> map = appservice.deleteApp(id);
		return map;
	}
	
	@RequestMapping(value="/appList.html",method = RequestMethod.GET)
	public String appList(){
		_log.info("permission/app/appEdit.html");
		return "uam/permission/appList";
	}
	
	/**
	 * 异步加载角色json数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appList.json",method = RequestMethod.POST)
	public @ResponseBody Page<App> roleList(Pageable page, String appName,String appCname,String hostname,String webContext) throws Exception {
		Searchable searchable = Searchable.newSearchable();
		searchable.setPage(page);
		if(StringUtils.isNotEmpty(appName)){
			searchable.addSearchParam("appName_like", appName);
		}
		if(StringUtils.isNotEmpty(appCname)){
			searchable.addSearchParam("appCname_like", appCname);
		}
		if(StringUtils.isNotEmpty(hostname)){
			searchable.addSearchParam("hostname_like", hostname);
		}
		if(StringUtils.isNotEmpty(webContext)){
			searchable.addSearchParam("webContext_like", webContext);
		}
		searchable.addSearchParam("isDeleted_eq",'0');
		searchable.addSort(new Sort(Direction.ASC, "orderby"));
		searchable.addSort(new Sort(Direction.DESC, "createDate"));
		Page<App> result = appservice.findAll(searchable);
		for (App app : result.getContent()) {
			app.setAvailable(AvailableStatus.getValueByCode(app.getAvailable()));
		}
		return result;
	}
	
}
