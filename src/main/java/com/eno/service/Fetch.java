package com.eno.service;

import java.util.HashMap;
import java.util.Map;

import com.namphy.web.framework.s2sf.service.anno.connector.IService;
import com.namphy.web.framework.s2sf.service.anno.entity.ServiceBean;
@ServiceBean
public class Fetch implements IService{

	
	@Override
	public Object execute(Map<String, String> params) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("user", "tester"); 
		return map;
	}
	 
}
