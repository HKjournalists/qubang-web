package com.mtech.common.quickQuery.configs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Pages {
	@XmlElement
	private String jsp;

	@XmlElement
	private String js;

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}
}
