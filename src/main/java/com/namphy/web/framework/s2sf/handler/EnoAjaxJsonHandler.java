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
 * @author duan.george.genophy.namphy 6:04:53 PM
 * 
 *         Servlet implementation class EnoAjaxJsonHandler
 */

@WebServlet("/enoAjaxJsonHandler")
public class EnoAjaxJsonHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnoAjaxJsonHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> requestParamterArr = request.getParameterMap();
		Map<String, String> requestParamters = HandlerTool.paraseRequstMapToNormalMap(requestParamterArr);
		try {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(CoreService.executeAndReturnJsonString(getServletContext(), requestParamters));
		} catch (Exception e) {
			e.printStackTrace();
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
