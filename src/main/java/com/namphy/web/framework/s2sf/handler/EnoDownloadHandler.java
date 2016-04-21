package com.namphy.web.framework.s2sf.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namphy.web.framework.s2sf.entity.bean.stream.bean.StreamObject;
import com.namphy.web.framework.s2sf.handler.tool.HandlerTool;
import com.namphy.web.framework.s2sf.service.anno.tool.CoreService;

/**
 * Servlet implementation class EnoStreamHandler
 */
@WebServlet("/enoDownloadHandler")
public class EnoDownloadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnoDownloadHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> requestParamterArr = request.getParameterMap();
		Map<String, String> requestParamters = HandlerTool.paraseRequstMapToNormalMap(requestParamterArr);

		InputStream inputStream = null;

		try {
			StreamObject streamObject = CoreService.executeAndReturnStreamObject(getServletContext(), requestParamters);

			inputStream = (InputStream) streamObject.getStream();
			String streamName = (String) streamObject.getName();
			String streamContentType = (String) streamObject.getContentType();

			response.setContentType(null != streamContentType ? streamContentType : "application/octet-stream"); // 默认二进制
			response.setContentLength(inputStream.available()); // 文件大小
			// 设置名称，顺带解决中文乱码问题
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"",   new String(streamName.getBytes("utf-8"), "ISO_8859_1") ));

			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				response.getOutputStream().write(buffer, 0, bytesRead);
			}

		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.getOutputStream().flush();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
