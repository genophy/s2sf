/**
 * ServiceBean.java
 *
 *  Created on: Sep 26, 2014 12:19:11 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.service.anno.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author duan.george.genophy.namphy
 *
 */

@Documented
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE)
public @interface ServiceBean {
	String name () default ""; 
}
