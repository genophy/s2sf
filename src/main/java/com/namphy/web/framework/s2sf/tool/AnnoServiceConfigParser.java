/**
 * XMLConfigParser.java
 *
 *  Created on: Sep 30, 2014 12:58:56 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.namphy.core.util.Util;
import com.namphy.web.framework.s2sf.util.Constants;

/**
 * 注解的l配置文件解析
 * 
 * @author duan.george.genophy.namphy
 */
public class AnnoServiceConfigParser {

	private static Document document;

	private AnnoServiceConfigParser() {

	}

	/**
	 * 初始化xml文件
	 * 
	 * @param path
	 * @return
	 */
	public static boolean init(ServletContext servletContext) {
		if (null != servletContext) {
			String xmlPath = getConfigPath(servletContext);
			if (Util.isNotBlank(xmlPath)) {
				try {
					document = new SAXReader().read(new File(xmlPath));
					return true;
				} catch (DocumentException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static List<String> getPkgList() {
		Element rootElement = document.getRootElement();
		Element serviceListElement = rootElement.element("service").element(
				"list");
		List<String> pkgList = new ArrayList<String>();
		List<Element> items = serviceListElement.elements("item");
		for (Element item : items) {
			pkgList.add(item.getTextTrim());
		}
		return pkgList;
	}

	/**
	 * 获取配置文件地址
	 * 
	 * @param servletContext
	 * @return
	 */
	private static String getConfigPath(ServletContext servletContext) {
		if (null != servletContext) {
			String xmlPath = servletContext
					.getInitParameter(Constants.ANNO_XML_CONFIG_LOCATION);
			if (Util.isNotBlank(xmlPath)) {
				String rootPath = null;
				if (xmlPath.toLowerCase().indexOf("classpath:") >= 0) { // src目录下
					rootPath = AnnoServiceConfigParser.class
							.getClassLoader()
							.getResource(
									xmlPath.substring(10, xmlPath.length())
											.replace(".", "/")
											.replaceAll("\\/xml$", "\\.xml"))
							.getPath();
				} else {
					rootPath = servletContext.getRealPath("")
							+ (xmlPath.indexOf("/") == 0 ? xmlPath : System.getProperty("file.separator")
									+ xmlPath);
					
				}
				return rootPath;
			}
		}
		return null;
	}

}
