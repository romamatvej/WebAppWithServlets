package by.jd.matveev.utils;

import java.sql.Connection;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.jd.matveev.beans.Client;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	// Store Connection in request attribute
	// Information stored only exist during request
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Get the connection object has been stored in attribute of the request
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Store user info in session
	public static void storeLoginedUser(HttpSession session, Client client) {
		// On the JSP can access via ${LoginedUser}
		session.setAttribute("loginedUser", client);
	}

	// Get the user information stored in the session
	public static Client getLoginedUser(HttpSession session) {
		Client loginedUser = (Client) session.getAttribute("loginedUser");
		return loginedUser;
	}

	// Store info in cookie
	public static void storeUserCookie(HttpServletResponse response, Client client) {
		System.out.println("Store uswe cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, client.getName());
		// 1 day converted to seconds
		cookieUserName.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieUserName);
	}

	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Delete cookie
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		// 0 secons (this cookie will expire immediately)
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}

}
