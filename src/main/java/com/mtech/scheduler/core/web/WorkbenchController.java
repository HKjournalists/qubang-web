package com.mtech.scheduler.core.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtech.common.utils.IdUtil;
import com.mtech.common.web.validate.AjaxResponse;
import com.mtech.scheduler.core.vo.Menu;


@Controller
@RequestMapping("/workbench")
public class WorkbenchController {
    
	
	@RequestMapping("/login.html")
	public String toLogin(HttpServletRequest req){
		
		return "login";
	}
	
	@RequestMapping("/login.json")
	public @ResponseBody AjaxResponse login(HttpServletRequest req){
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		    UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);  
		    Subject subject = SecurityUtils.getSubject();  
		        subject.login(token);  
		        if (subject.isAuthenticated()) {  
		        	return AjaxResponse.success();
		        } else {  
		        	return AjaxResponse.fail();
		        }  
		
		/*if(userName.equalsIgnoreCase("admin")&&pwd.equalsIgnoreCase("123456")){
			HttpSession session = req.getSession();
			session.setAttribute("login", "login");
			return AjaxResponse.success();
		}
		return AjaxResponse.fail();*/
	}
	
	@RequestMapping("/logout.json")
	public @ResponseBody AjaxResponse logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("login");
		return AjaxResponse.success();
	}
	
	
    @RequestMapping("/welcome.html")
    public String welcome(){
    	return "welcome";
    }
	
    @RequestMapping("/index.html")
    public ModelAndView index(HttpServletRequest request,ModelAndView model){
    	String contextPath = request.getContextPath();
    	model.getModel().put("welcomePage", contextPath+"/workbench/welcome.html");	
    	model.setViewName("index");
        return model;
    }

	@RequestMapping(value = "/menuList.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getMenu(HttpServletRequest req) {
		String contextPath = req.getContextPath();
		Map<String, List<Menu>> map = new HashMap<String, List<Menu>>();
		List<Menu> list = new ArrayList<Menu>();
		Menu menu1 = new Menu();
		Menu menu4 = new Menu();
		Menu menu5 = new Menu();
		Menu menu6 = new Menu();
		Menu menu7 = new Menu();
		menu1.setId(IdUtil.getUUId());
		menu1.setMenuName("应用管理");
		menu1.setUrl(contextPath+"/permission/app/appList.html");
		
		menu4.setId(IdUtil.getUUId());
		menu4.setMenuName("user");
		menu4.setUrl(contextPath+"/usr/user/list.html");
		
		menu5.setId(IdUtil.getUUId());
		menu5.setMenuName("userHelpFavorite");
		menu5.setUrl(contextPath+"/usr/userHelpFavorite/list.html");
		
		menu6.setId(IdUtil.getUUId());
		menu6.setMenuName("userSuggest");
		menu6.setUrl(contextPath+"/usr/userSuggest/list.html");
	

		menu7.setId(IdUtil.getUUId());
		menu7.setMenuName("帮助管理");
		menu7.addChild("hel",contextPath+"/hel/help/list.html");
		menu7.addChild("helper",contextPath+"/hel/helper/list.html");
		
		list.add(menu1);
		list.add(menu4);
		list.add(menu5);
		list.add(menu6);
		list.add(menu7);
		map.put("list", list);
		return new ResponseEntity<Map<String, List<Menu>>>(map, HttpStatus.OK);
	}

}
