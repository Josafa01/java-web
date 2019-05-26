package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoLogin;

@WebServlet("/LogOffServlet")
public class LogOffServlet extends HttpServlet {

	private static final long serialVersionUID = 1l;

	private DaoLogin daologin = new DaoLogin();

	public LogOffServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		String email = (String) session.getAttribute("email");

		if (email != null) {
			String email_seesion = email.toString().replaceAll("\\<.*?>", "");

			if (session != null) {
				try {
					daologin.SaveLogin("0", 0, email_seesion);
					session.invalidate();
					response.sendRedirect("index.jsp");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				daologin.SaveLogin("0", 0, email);
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
