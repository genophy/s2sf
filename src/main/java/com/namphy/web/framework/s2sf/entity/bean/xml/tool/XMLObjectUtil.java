package com.namphy.web.framework.s2sf.entity.bean.xml.tool;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.namphy.core.util.Util;

/**
 * xml格式对象帮助类
 * 
 * @author duan.george.genophy.namphy
 *
 */
public class XMLObjectUtil {

	private Document xmlDocument;

	public XMLObjectUtil() {
		this.xmlDocument = DocumentHelper.createDocument();
	}

	public XMLObjectUtil setResultXML(String result) {
		Element resultTag = this.xmlDocument.addElement("result");
		resultTag.setText(result);
		return this;
	}

	/**
	 * 
	 * @param lists
	 */
	public boolean listsParseAble(List<Map<String, String>> list) {
		// if list is null, return
		if (null == list || list.size() < 2) {
			createXMLDocuemntNoResult();
			return false;
		}
		appendListsToXMLDocument(getXMLDocumentResult(), list);
		return true;
	}

	public String toString() {
		if (null == xmlDocument) {
			return null;
		}
		return xmlDocument.asXML();
	}

	/**
	 * 
	 * @param lists
	 * @return
	 */
	private void appendListsToXMLDocument(Element resultElement,
			List<Map<String, String>> list) {
		Element listElement = getXmlListOfAttr(resultElement, list.get(0));
		for (int i = 1; i < list.size(); i++) {
			Element item = listElement.addElement("item");
			fillElementAttr(item, list.get(i));
		}
	}

	/**
	 * set xmlListAttr <br/>
	 * <p>
	 * e.g.&nbsp;:&nbsp;<br/>
	 * &lt;list pageIdx="" pageSize="" pageCSize="" pageTotal=""
	 * total=""&gt;&lt;/list&gt;
	 * </p>
	 * 
	 * @param maps
	 */
	private Element getXmlListOfAttr(Element resultElement,
			Map<String, String> map) {
		Element listElement = resultElement.addElement("list");
		return fillElementAttr(listElement, map);
	}

	/**
	 * 
	 * @param element
	 * @param map
	 * @return
	 */
	private Element fillElementAttr(Element element, Map<String, String> map) {
		Set<String> sets = map.keySet();
		for (String set : sets) {
			if (Util.isNotBlank(set)) {
				element.addAttribute(set, map.get(set));
			}
		}
		return element;
	}

	private Element getXMLDocumentResult() {
		return xmlDocument.addElement("result");
	}

	/**
	 * 
	 */
	private void createXMLDocuemntNoResult() {
		xmlDocument.addElement("no-result");
	}

}
