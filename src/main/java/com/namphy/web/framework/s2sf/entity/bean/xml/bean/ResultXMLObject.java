/**
 * ResultXMLObject.java
 *
 *  Created on: Sep 25, 2014 12:55:49 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.entity.bean.xml.bean;

/**
 * @author duan.george.genophy.namphy
 *
 */
public class ResultXMLObject extends XMLObject {
	@Override
	public String toXML() {
		return toXML("result");
	}
}
