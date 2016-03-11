package com.mtech.common.quickQuery.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mtech.common.quickQuery.configs.QuerysContext;
import com.mtech.common.quickQuery.service.QuerysParseService;

/**
 * 通用查询组件统一入口
 * @author hzy
 *
 */
@Controller
public class QueryController {

	private final static Logger logger = LoggerFactory
			.getLogger(QueryController.class);
	
	@Autowired
	private QuerysParseService querysParseService;


	@RequestMapping(value = "/quickGrid/query", method = RequestMethod.GET)
	public String redirectTo(@RequestParam("queryId") String queryId,Model model) {
		logger.debug("queryId:" + queryId);
		model.addAttribute("queryId", queryId);
		
		querysParseService.reloadFile();
		QuerysContext queryContext = QuerysContext.getInstance();
		String jspURL = queryContext.getQuery(queryId).getPages().getJsp();
		String jsURL = queryContext.getQuery(queryId).getPages().getJs();
		model.addAttribute("jsURL", jsURL);
		logger.debug("jspURL:" + jspURL);
		logger.debug("jsURL:" + jsURL);
		return jspURL;
	}
}
