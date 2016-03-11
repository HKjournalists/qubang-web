/**    
 * Copyright (C),Kingmed
 * @FileName: NumberFormatter.java  
 * @Package: com.kingmed.platform.modules.quickQuery.formatter  
 * @Description: //模块目的、功能描述  
 * @Author HuangSiwei  
 * @Date 2014年8月25日 上午11:06:31  
 * @History: //修改记录
 * 〈author〉      〈time〉      〈version〉       〈desc〉
 * 修改人姓名            修改时间            版本号              描述   
 */

package com.mtech.common.quickQuery.formatter;

import java.text.NumberFormat;

/**
 * 〈一句话功能简述〉 功能详细描述
 * 
 * @author HuangSiwei
 * @create 2014年8月25日 上午11:06:31
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public class NumberFormatter implements IFormatter {

	private boolean groupingUsed = true;

	private int maximumFractionDigits = 3;

	private int maximumIntegerDigits = 40;

	private int minimumFractionDigits = 0;

	private int minimumIntegerDigits = 1;

	@Override
	public String format(Object value) {
		NumberFormat format = NumberFormat.getInstance();

		format.setGroupingUsed(this.groupingUsed);

		format.setMaximumFractionDigits(this.maximumFractionDigits);

		format.setMaximumIntegerDigits(this.maximumIntegerDigits);

		format.setMinimumFractionDigits(this.minimumFractionDigits);

		format.setMinimumIntegerDigits(this.minimumIntegerDigits);

		return format.format(value);
	}

	/**
	 * 返回 groupingUsed 的值
	 * 
	 * @return groupingUsed
	 */

	public boolean isGroupingUsed() {
		return groupingUsed;
	}

	/**
	 * 设置 groupingUsed 的值
	 * 
	 * @param groupingUsed
	 */

	public void setGroupingUsed(boolean groupingUsed) {
		this.groupingUsed = groupingUsed;
	}

	/**
	 * 返回 maximumFractionDigits 的值
	 * 
	 * @return maximumFractionDigits
	 */

	public int getMaximumFractionDigits() {
		return maximumFractionDigits;
	}

	/**
	 * 设置 maximumFractionDigits 的值
	 * 
	 * @param maximumFractionDigits
	 */

	public void setMaximumFractionDigits(int maximumFractionDigits) {
		this.maximumFractionDigits = maximumFractionDigits;
	}

	/**
	 * 返回 maximumIntegerDigits 的值
	 * 
	 * @return maximumIntegerDigits
	 */

	public int getMaximumIntegerDigits() {
		return maximumIntegerDigits;
	}

	/**
	 * 设置 maximumIntegerDigits 的值
	 * 
	 * @param maximumIntegerDigits
	 */

	public void setMaximumIntegerDigits(int maximumIntegerDigits) {
		this.maximumIntegerDigits = maximumIntegerDigits;
	}

	/**
	 * 返回 minimumFractionDigits 的值
	 * 
	 * @return minimumFractionDigits
	 */

	public int getMinimumFractionDigits() {
		return minimumFractionDigits;
	}

	/**
	 * 设置 minimumFractionDigits 的值
	 * 
	 * @param minimumFractionDigits
	 */

	public void setMinimumFractionDigits(int minimumFractionDigits) {
		this.minimumFractionDigits = minimumFractionDigits;
	}

	/**
	 * 返回 minimumIntegerDigits 的值
	 * 
	 * @return minimumIntegerDigits
	 */

	public int getMinimumIntegerDigits() {
		return minimumIntegerDigits;
	}

	/**
	 * 设置 minimumIntegerDigits 的值
	 * 
	 * @param minimumIntegerDigits
	 */

	public void setMinimumIntegerDigits(int minimumIntegerDigits) {
		this.minimumIntegerDigits = minimumIntegerDigits;
	}

}
