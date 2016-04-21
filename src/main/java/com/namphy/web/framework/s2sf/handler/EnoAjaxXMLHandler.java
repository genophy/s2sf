package com.namphy.web.framework.s2sf.handler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namphy.web.framework.s2sf.handler.tool.HandlerTool;
import com.namphy.web.framework.s2sf.service.anno.tool.CoreService;

/**
 * 用于核心处理的servlet。本程序，只有此serlvet用于json或xml传输
 * 
 * @author duan.george.genophy.namphy
 * 
 *         Servlet implementation class EnoAjaxHandlerServlet
 */

@WebServlet("/enoAjaxXMLHandler")
public class EnoAjaxXMLHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnoAjaxXMLHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)  {
		Map<String, String[]> requestParamterArr = request.getParameterMap();
		Map<String, String> requestParamters = HandlerTool.paraseRequstMapToNormalMap(requestParamterArr);
		try {
			response.setContentType("application/xml; charset=UTF-8");
			response.getWriter().print(
					CoreService.executeAndReturnXMLString(getServletContext(),
							requestParamters));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

 
}
