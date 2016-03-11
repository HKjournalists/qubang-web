package com.mtech.common.quickQuery.web;
//package com.mtech.common.quickQuery.web;
//
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.mtech.common.entity.Permission;
//import com.mtech.common.entity.Permission.PERMISSION_TYPE;
//import com.mtech.common.quickQuery.configs.QuerysContext;
//import com.mtech.common.quickQuery.formatter.LigerGridForMatter;
//import com.mtech.common.quickQuery.service.QuerysParseService;
//import com.mtech.common.quickQuery.service.QuickGridService;
//
///**
// * 
// * 〈一句话功能简述〉 功能详细描述
// * 
// * @author HuangSiwei
// * @create 2014年8月21日 下午5:06:54
// * @version 1.0.0
// * @see [相关类/方法]（可选）
// * @since [产品/模块版本] （可选）
// */
//@Controller
//@RequestMapping(value = "/quickGrid")
//public class QuickQueryController {
//	private static final String SEARCH_PREFIX = "search_";
//
//	private static final Logger LOGGER =LoggerFactory.getLogger(QuickQueryController.class);
//
//	@Autowired
//	private QuerysParseService querysParseService;
//
//	@Autowired
//	private QuickGridService quickGridService;
//	
//
//	@RequestMapping(value = "findColumnNameList", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object>  findColumnNameList(
//			@RequestParam(value = "queryId") String queryId) {
//		LOGGER.debug("findColumnNameList:" + queryId);
//		querysParseService.reloadFile();
//
//		QuerysContext queryContext = QuerysContext.getInstance();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("data", queryContext.getQuery(queryId));
//		map.put("toolBar", getBar());
//		return map;
//		
//	}
//
//	@RequestMapping(value = "findPage", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> findPage(
//			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
//			@RequestParam(value = "rows", defaultValue = "10") int pageSize,
//			@RequestParam(value = "order", required = false) String order,// asc,desc
//			@RequestParam(value = "sort", required = false) String sort,// 排序的字段
//			@RequestParam(value = "queryId") String queryId,
//			HttpServletRequest request) {
//
//		querysParseService.reloadFile();
//
//		Map<String, String[]> searchParams = getSearchParameters(request);
//
//		LigerGridForMatter formatter = quickGridService.findGrid(queryId, searchParams, pageNumber,
//				pageSize, order, sort);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("Rows", formatter.getRows());
//		map.put("Total", formatter.getTotal());
//		
//		return map;
//		
//
//	}
//
//	private static Map<String, String[]> getSearchParameters(
//			ServletRequest request) {
//		String prefix = SEARCH_PREFIX;
//		Enumeration<String> paramNames = request.getParameterNames();
//		Map<String, String[]> params = new TreeMap<String, String[]>();
//
//		while ((paramNames != null) && paramNames.hasMoreElements()) {
//			String paramName = (String) paramNames.nextElement();
//			if ("".equals(prefix) || paramName.startsWith(prefix)) {
//				String unprefixed = paramName.substring(prefix.length());
//				unprefixed = unprefixed.endsWith("[]") ? unprefixed.substring(
//						0, unprefixed.length() - 2) : unprefixed;
//				String[] values = request.getParameterValues(paramName);
//
//				if (values != null && values.length > 0) {
//					params.put(unprefixed, values);
//				}
//			}
//		}
//
//		return params;
//	}
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private Map<String, Object> getBar(){
//		Map<String, Object> bor = new HashMap<String, Object>();
////		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();		 
////		Map<String, Object> add = new HashMap<String, Object>();
////		add.put("text", "新增");
////		add.put("click", "add");
////		add.put("icon", "add");
////		list.add(add);
////		Map<String, Object> line = new HashMap<String, Object>();
////		line.put("line", "true");
////		list.add(line);
////		
////		Map<String, Object> modify = new HashMap<String, Object>();
////		modify.put("text", "修改");
////		modify.put("click", "modify");
////		modify.put("icon", "modify");
////		list.add(modify);
////		list.add(line);
////		Map<String, Object> delete = new HashMap<String, Object>();
////		delete.put("text", "删除");
////		delete.put("click", "delete");
////		delete.put("img", "'${ctx}'/static/tbsp/images/delete.gif");
////		list.add(delete);
//		
//		List toolbarList = new ArrayList();
//		Map<String, Object> line =new HashMap<String, Object>();
//		line.put("line", true);
//		Permission add = new Permission("新增", PERMISSION_TYPE.add, "add", null, null);
//		toolbarList.add(add);
////		toolbarList.add(line);
////		Permission add2 = new Permission("我要新增", PERMISSION_TYPE.add, "add", "test", "static/tbsp/js/ligerui/skins/icons/delete.gif");
////		toolbarList.add(add2);
//		toolbarList.add(line);
//		Permission edit = new Permission("修改", PERMISSION_TYPE.edit, "edit", "", "");
//		toolbarList.add(edit);
//		toolbarList.add(line);
//		Permission del = new Permission("删除", PERMISSION_TYPE.del, "delete", "", "");
//		toolbarList.add(del);
//		bor.put("items", toolbarList);
//		return bor;
//	}
//}
