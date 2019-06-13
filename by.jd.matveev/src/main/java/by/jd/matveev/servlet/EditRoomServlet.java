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

@WebServlet(urlPatterns = { "/editRoom" })
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditRoomServlet() {
		super();
	}

	// Show product edit page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String roomNumberStr = (String) request.getParameter("number");

		String errorString = null;
		int roomNumber = 0;
		try {
			roomNumber = Integer.parseInt(roomNumberStr);
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		Room room = null;

		try {
			room = DBUtils.findRoom(conn, roomNumber);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		// If no error.
		// The product does not exist to edit.
		// Redirect to productList page.
		if (errorString != null && room == null) {
			response.sendRedirect(request.getServletPath() + "/roomList");
			return;
		}

		// Store errorString in request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("room", room);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editRoomView.jsp");
		dispatcher.forward(request, response);

	}

	// After the user modifies the product information, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String numberStr = (String) request.getParameter("number");
		String capacityStr = (String) request.getParameter("capacity");
		String smokingStr = (String) request.getParameter("smoking");
		int number = 0;
		int capacity = 0;
		int smoking = 0;
		if ("Y".equals(request.getParameter("smoking"))) {smoking = 1;}
		try {
			number = Integer.parseInt(numberStr);
			capacity = Integer.parseInt(capacityStr);
		} catch (Exception e) {
		}
		Room room = new Room(number, capacity, smoking);

		String errorString = null;

		try {
			DBUtils.updateRoom(conn, room);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("room", room);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/editRoomView.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/roomList");
		}
	}

}
