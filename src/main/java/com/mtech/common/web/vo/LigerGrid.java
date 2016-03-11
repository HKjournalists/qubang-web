/**   
 * TODO(用一句话描述该文件做什么) 
 * @author Jiarong 
 * @date 2014年12月3日 下午10:26:13 
 * @version 0.0.1
 */
package com.mtech.common.web.vo;

import java.util.List;

/** 
 * TODO(这里用一句话描述作用) 
 *
 * @author Jiarong
 * @date 2014年12月3日 下午10:26:13 
 * @version 0.0.1
 *  
 */
public class LigerGrid {

	private List<Object> rows;

	public LigerGrid(List<Object> rows){
		this.rows = rows;
	}
	
	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
