package me.donkey.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import me.donkey.entity.Car;
import me.donkey.service.impl.CarServiceImpl;
import me.donkey.util.DBUtil;

/**
 * Servlet implementation class Car
 */
@WebServlet(name = "car", urlPatterns = { "/car.action" })
public class CarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarServiceImpl carService = new CarServiceImpl();

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("type");
		if (act.equals("single")) {
			int id = Integer.parseInt(request.getParameter("id"));
			response.getWriter().println(
					JSONObject.fromObject(carService.getCarById(id)));
		} else {
			response.getWriter().println(
					JSONArray.fromObject(carService.getAllCars()));
		}
	}
}
