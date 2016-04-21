package com.namphy.web.framework.s2sf.handler.tool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HandlerTool {

	

	/**
	 * 将request的Map转化为普通的Map对象
	 * 
	 * parse Map<String,String[]> to Map<String,String>
	 */
	public static Map<String, String> paraseRequstMapToNormalMap(
			Map<String, String[]> maps) {
		Map<String, String> temp_map = new HashMap<String, String>();
		Set<String> keys = maps.keySet();
		for (String key : keys) {
			temp_map.put(key, maps.get(key)[0]);
		}
		return temp_map;
	}
}
