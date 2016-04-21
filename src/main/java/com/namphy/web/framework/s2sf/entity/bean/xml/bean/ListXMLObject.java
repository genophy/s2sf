/**
 * ListXMLObject.java
 *
 *  Created on: Sep 25, 2014 11:41:21 PM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.entity.bean.xml.bean;

/**
 * XML列表对象
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class ListXMLObject extends XMLObject {
	
	
	@Override
	public String toXML() {
		return toXML("list");
	}

}
