/**
 * ItemXMLObject.java
 *
 *  Created on: Sep 25, 2014 8:18:56 PM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.entity.bean.xml.bean;


/**
 * @author duan.george.genophy.namphy
 *
 */
public class ItemXMLObject extends XMLObject {
	
	@Override
	public String toXML() {
		return toXML("item");
	}

}
