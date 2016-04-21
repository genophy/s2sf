/**
 * CoreService.java
 *
 *  Created on: Sep 25, 2014 1:18:03 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.service.anno.tool;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import com.namphy.web.framework.s2sf.entity.bean.stream.bean.StreamObject;
import com.namphy.web.framework.s2sf.tool.AnnoServiceConfigParser;
import com.namphy.web.framework.s2sf.util.Constants;

/**
 * 核心服务程序。所有返回字符的服务，都经过这
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class CoreService {

	/**
	 * 执行并且返回xml格式的字符串
	 * 
	 * @param paramters
	 * @return
	 * @throws Exception
	 */
	public static String executeAndReturnXMLString(ServletContext servletContext,Map<String, String> paramters)
			throws Exception {

		String beanName = paramters.get(Constants.ANNO_BEAN);
		//解析出pkgList
 		List<String> pkgList = null;
		if(AnnoServiceConfigParser.init(servletContext)){
			pkgList = AnnoServiceConfigParser.getPkgList();
		}
		
		String clazzName = ServiceBeanFactory.getClazzName(pkgList, beanName);
		return ServiceBeanFactory.execute(clazzName, paramters,"xml");
	}
 
	
	

	/**
	 * 执行并且返回Json格式的字符串
	 * 
	 * @param paramters
	 * @return
	 * @throws Exception
	 */
	public static String executeAndReturnJsonString(ServletContext servletContext,Map<String, String> paramters)
			throws Exception {

		String beanName = paramters.get(Constants.ANNO_BEAN);
		//解析出pkgList
 		List<String> pkgList = null;
		if(AnnoServiceConfigParser.init(servletContext)){
			pkgList = AnnoServiceConfigParser.getPkgList();
		}
		
		String clazzName = ServiceBeanFactory.getClazzName(pkgList, beanName);
		return ServiceBeanFactory.execute(clazzName, paramters,"json");
	}
 
	

	/**
	 * 执行并且返回Stream
	 * 
	 * @param paramters
	 * @return
	 * @throws Exception
	 */
	public static StreamObject executeAndReturnStreamObject(ServletContext servletContext,Map<String, String> paramters)
			throws Exception {

		String beanName = paramters.get(Constants.ANNO_BEAN);
		//解析出pkgList
 		List<String> pkgList = null;
		if(AnnoServiceConfigParser.init(servletContext)){
			pkgList = AnnoServiceConfigParser.getPkgList();
		}
		
		String clazzName = ServiceBeanFactory.getClazzName(pkgList, beanName);
		return ServiceBeanFactory.executeForStreamObject(clazzName, paramters);
	}
}
