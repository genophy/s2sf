/**
 * ServiceDone.java
 *
 *  Created on: Sep 26, 2014 12:30:53 AM
 *      Author: duan.george.genophy.namphy
 * 
 */
package com.namphy.web.framework.s2sf.service.anno.util;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import com.namphy.core.util.Util;

/**
 * 
 * the service done
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class AnnoUtil {
	// 全局path
	public static String global_src_root_path = AnnoUtil.class
			.getClassLoader().getResource("").getPath();
	 
	private static List<Class<?>> clazzList = null;

	/**
	 * 获取所有包下的类
	 * 
	 * @param pkg
	 *            包名
	 * @return
	 */
	public static List<Class<?>> getAllClazzes(String rootPath, List<String> pkg) {
		if (null == clazzList) {
			clazzList = getAllClazzesList(rootPath, pkg);
		}
		return clazzList;
	}

	/**
	 * 获取所有注解类相关的类
	 * 
	 * @param rootPath
	 *            根目录
	 * @param pkg
	 *            包名
	 * @param annoClazz
	 *            注解类
	 * @return
	 */
	public static List<Class<?>> getAllAnnoClazzes(String rootPath, List<String> pkg,
			Class<? extends Annotation> annoClazz) {
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		if (null != getAllClazzes(rootPath, pkg)) {
			for (Class<?> clazz : getAllClazzes(rootPath, pkg)) {
				if (clazz.isAnnotationPresent(annoClazz)) {
					clazzes.add(clazz);
				}
			}
		}
		return clazzes;
	}

	/**
	 * 获取所有注解类相关的类
	 * 
	 * @param rootPath
	 *            根目录
	 * @param pkg
	 *            包名
	 * @param annoClazz
	 *            注解类
	 * @param beanName
	 *            类名,默认匹配首字母小写
	 * @return
	 */
	public static Class<?> getAnnoClazzes(String rootPath, List<String> pkg, Class<? extends Annotation> annoClazz,
			String beanName) {
		List<Class<?>> clazzes = getAllAnnoClazzes(rootPath, pkg, annoClazz);
		for (Class<?> clazz : clazzes) {
			String str = clazz.getName();
			if (beanName.equals(Util.parseStrToLowHead(str))) {
				return clazz;
			}
		}
		return null;
	}

	/**
	 * 获取所有注解的类
	 * 
	 * @param pkg
	 * @param annoClazz
	 * @return
	 */
	private static List<Class<?>> getAllClazzesList(String rootPath, List<String> pkg) {
		List<Class<?>> clazzes = new ArrayList<Class<?>>();
		List<String> list = getClassName(rootPath, pkg);
		try {
			for (String str : list) {
				Class<?> clazz = Class.forName(str);
				clazzes.add(clazz);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clazzes;
	}

	/**
	 * 获取所有类名
	 * 
	 * @param rootPath
	 *            根目录
	 * @param filePath
	 * @param basePkg
	 * @return
	 */
	private static List<String> getClassName(String rootPath, List<String> pkgList) {
		return getClassNameFromPkgList(rootPath, pkgList);
	}

	/**
	 * 获取包下所有类名
	 * 
	 * @param rootPath
	 * @param pkgList
	 * @return <list[String]> className
	 */
	private static List<String> getClassNameFromPkgList(String rootPath, List<String> pkgList ) {
		List<String> myClassName = new ArrayList<String>();

		File rootFileOrDir = new File(rootPath);
		if (rootFileOrDir.isDirectory()) { // 若根文件是目录,则便利下面的包

			if (null != pkgList && 0 != pkgList.size()) { // 若包列表存在，则便利包列表
				for (String pkg  : pkgList) {
					String pkgFullPath = rootPath.concat(pkg.replaceAll("\\.", System.getProperty("file.separator")));
					myClassName.addAll(getClassNameFromPkgList(pkgFullPath, null ));

				}
			}
			// 若包列表不存在，则遍历rootpath的目录
			else {
				for (File children : rootFileOrDir.listFiles()) {
					myClassName.addAll(getClassNameFromPkgList(children.getAbsolutePath(), null ));
				}
			}

		}

		// 若根文件不是目录，则增加到className中
		else {
			String fileFullName = rootFileOrDir.getAbsolutePath();
			if (fileFullName.endsWith(".class")) {
				String className = fileFullName.replace(global_src_root_path,"").replaceAll("\\.class$", "").replace(System.getProperty("file.separator"), ".");
				myClassName.add(className);
			}
		} 
		return myClassName;

	} 

}
