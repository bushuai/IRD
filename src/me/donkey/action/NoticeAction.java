package me.donkey.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.donkey.service.NoticeService;
import me.donkey.service.impl.NoticeServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet(name = "notice", urlPatterns = { "/notice.action" })
public class NoticeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NoticeService ns = new NoticeServiceImpl();

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().println(JSONArray.fromObject(ns.getAllNotice()));
	}
}
