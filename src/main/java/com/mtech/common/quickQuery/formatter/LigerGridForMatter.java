package com.mtech.common.quickQuery.formatter;
//package com.mtech.common.quickQuery.formatter;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
//import oracle.sql.CLOB;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class LigerGridForMatter {
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	public LigerGridForMatter(){
//		
//	}
//	public LigerGridForMatter(List<Map<String, Object>> rows,Long total){
//		this.Rows = rows;
//		convertClob(rows);
//		this.Total = total;
//	}
//	/** 
//	 * TODO : 这个方法的最长度解决办法为在Spring MVC 的Converter做转化
//	 * @param rows2 
//	 * @return void    返回类型 
//	 */
//	private void convertClob(List<Map<String, Object>> rows2) {
//		for(Map<String, Object> map : rows2){
//			for(String key : map.keySet()){
//				if(map.get(key)!=null){
//					//logger.debug(map.get(key).getClass().getName());					
//					if(map.get(key) instanceof CLOB){
//						String value = "";
//						try {
//							value = ((CLOB)map.get(key)).stringValue();
//						} catch (SQLException e) {
//							//DO NOTHING
//						}
//						map.put(key, value);
//					}
//				}
//			}
//		}
//		
//	}
//	private List<Map<String, Object>> Rows;
//	private Long Total;
//	public List<Map<String, Object>> getRows() {
//		return Rows;
//	}
//	public void setRows(List<Map<String, Object>> rows) {
//		Rows = rows;
//	}
//	public Long getTotal() {
//		return Total;
//	}
//	public void setTotal(Long total) {
//		Total = total;
//	}
//	
//
//}
