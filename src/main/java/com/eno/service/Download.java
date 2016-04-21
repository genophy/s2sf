package com.eno.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import com.namphy.web.framework.s2sf.entity.bean.stream.bean.StreamObject;
import com.namphy.web.framework.s2sf.service.anno.connector.IService;
import com.namphy.web.framework.s2sf.service.anno.entity.ServiceBean;

@ServiceBean
public class Download implements IService {

	@Override
	public Object execute(Map<String, String> params) {

		File file = new File("/home/eno/Videos/黑夜传说2进化.720p.国英双语.BD中英双字.mkv");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return new StreamObject(file.getName(), null, fis);
	}

}
