/**
 * NoResultXMLObject.java
 *
 *  Created on: Sep 27, 2014 11:43:30 PM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.entity.bean.xml.bean;


/**
 * @author duan.george.genophy.namphy
 *
 */
public class NoResultXMLObject  extends ResultXMLObject{
	@Override
	public String toXML() {
		return toXML("no_result");
	}
}
