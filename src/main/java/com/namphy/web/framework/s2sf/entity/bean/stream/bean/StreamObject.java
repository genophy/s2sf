package com.namphy.web.framework.s2sf.entity.bean.stream.bean;

import java.io.InputStream;

/**
 * 流对象
 * 
 * @author duan.george.genophy.namphy 10:14:49 PM
 *
 */
public class StreamObject {
	private String name;
	private String contentType;
	private InputStream stream;

	public StreamObject(String name, String contentType, InputStream stream) {
		super();
		this.name = name;
		this.contentType = contentType;
		this.stream = stream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

}
