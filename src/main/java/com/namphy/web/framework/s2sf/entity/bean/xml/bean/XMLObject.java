package com.namphy.web.framework.s2sf.entity.bean.xml.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.namphy.core.tool.FormatBuilderHelper;
import com.namphy.core.util.Util;
import com.namphy.web.framework.s2sf.entity.bean.basic.TextObject;

/**
 * 
 * @author duan.george.genophy.namphy 5:41:49 PM
 * @category 实体类
 */
public abstract class XMLObject extends TextObject {
	/**
	 * 属性
	 */
	private Map<String, String> properties;

	private List<XMLObject> xmlObjectChildList;
	/**
	 * 内容
	 */
	private String content;

	public XMLObject() {
		properties = new HashMap<String, String>();
	}

	/**
	 * 增加子节点
	 * 
	 * @param xmlObject
	 */
	public void addChild(XMLObject xmlObject) {
		if (null == xmlObjectChildList) {
			xmlObjectChildList = new ArrayList<XMLObject>();
		}
		xmlObjectChildList.add(xmlObject);
	}

	/**
	 * 获取所有子节点
	 * 
	 * @return
	 */
	public List<XMLObject> getChildren() {
		return xmlObjectChildList;
	}

	/**
	 * 增加属性
	 * 
	 * @param key
	 * @param value
	 */
	public void addProperty(String key, String value) {
		properties.put(key, value);
	}

	/**
	 * 删除属性
	 * 
	 * @param key
	 */
	public void removeProperty(String key) {
		properties.remove(key);
	}

	/**
	 * 提取属性
	 * 
	 * @param key
	 * @return
	 */
	public String popProperty(String key) {
		String str = properties.get(key);
		properties.remove(key);
		return str;
	}

	/**
	 * 获取所有key
	 * 
	 * @return
	 */
	public Set<String> getPropertyKeys() {
		return properties.keySet();
	}

	/**
	 * 获取所有值
	 * 
	 * @return
	 */
	public Collection<String> getPropertyValues() {
		return properties.values();
	}

	/**
	 * 获取所有属性
	 * 
	 * @return the properties
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * 获取内容
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 设置内容，CDATA格式
	 * 
	 * @param content
	 */
	public void setContentCDATA(String content) {
		this.content = new StringBuffer().append("[CDATA[").append(content).append("]]").toString();
	}

	/**
	 * 转换成XML字符串
	 * 
	 * @return
	 */
	public String toXML() {
		return "";
	}

	/**
	 * 返回XML格式的字符
	 * 
	 * 
	 * @param elementName
	 *            元素名
	 * @return
	 */
	protected String toXML(String elementName) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("<");
		sbf.append(elementName);
		sbf.append(FormatBuilderHelper.buildXMLPropertiesKV(getProperties()));
		sbf.append(">");
		if (!Util.isBlank(getContent())) {
			sbf.append(getContent());
		} else if (null != getChildren() && 0 < getChildren().size()) {
			for (XMLObject xo : getChildren()) {
				sbf.append(xo.toXML());
			}
		}
		sbf.append("</").append(elementName).append(">");
		return sbf.toString();
	}
}
