package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLogin;

@WebServlet("/Leia")
public class Leia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoLogin daologin = new DaoLogin();

	public Leia() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String sessionID = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("JSESSIONID"))
						sessionID = cookie.getValue();
				}
			}

			String email = (String) request.getSession().getAttribute("email");
			if (email != null) {
				String email_session = email.toString().replaceAll("\\<.*?>", "");
				String hash = daologin.getHash(email_session);

				if (!hash.equals(sessionID)) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("Leia.jsp");
					dispatcher.forward(request, response);
				}

				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(20000);

			} else {
				String cookie = daologin.lastCookie();
				String last_email = daologin.getLogin(cookie);
				daologin.SaveLogin("0", 0, last_email);
				response.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Leia.jsp");
		dispatcher.forward(request, response);
	}

}