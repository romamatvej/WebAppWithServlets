package by.jd.matveev.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd.matveev.beans.Room;
import by.jd.matveev.utils.MyUtils;
import by.jd.matveev.utils.DBUtils;

@WebServlet(urlPatterns = { "/createRoom" })
public class CreateRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateRoomServlet() {
		super();
	}

	// Show room creation page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createRoomView.jsp");
		dispatcher.forward(request, response);
	}

	// When the user enters the product information, and click Submit.
	// This method will be called.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String numberStr = (String) request.getParameter("number");
		String capacityStr = (String) request.getParameter("capacity");
		String smokingStr = (String) request.getParameter("smoking");
		int number = 0;
		int capacity = 0;
		try {
			number = Integer.parseInt(numberStr);
		} catch (Exception e) {
		}
		try {
			capacity = Integer.parseInt(capacityStr);
		} catch (Exception e) {
		}
		int smoking = 0;
		if("Y".equals(smokingStr)) {smoking = 1;}
		Room room = new Room(number, capacity, smoking);

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character
//		String regex = "\\w+";

		if (number == 0 || capacity == 0/*!code.matches(regex)*/) {
			errorString = "Number and capacity must be set";
		}

		if (errorString == null) {
			try {
				DBUtils.insertRoom(conn, room);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("room", room);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/roomList");
		}
	}

}
