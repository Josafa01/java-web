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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1l;

	private DaoLogin daologin = new DaoLogin();

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			HttpSession session = request.getSession(true);

			int status = daologin.StatusLog(email);
			String hash = daologin.getHash(email);
			boolean log = daologin.validarLogin(email, senha);

			String sessionID = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("JSESSIONID"))
						sessionID = cookie.getValue();

				}
			}

			if (log == true && !hash.equals(sessionID) && status == 0) {

				if (request.getParameter("email") != null && request.getParameter("senha") != null) {
					session.setAttribute("email", "<div class='user-logged'><p>" + email + "</p></div>");
					daologin.SaveLogin(sessionID, 1, email);
					response.sendRedirect("painel.jsp");
				} else {
					daologin.SaveLogin("0", 0, email);
					session.removeAttribute("email");
					response.sendRedirect("index.jsp");
				}

			} else if (log == false) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				session.setAttribute("message", "    <div class=\"alert alert-danger alert-dismissible fade show\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>E-mail e/ou senha invalidos</strong>" + "    </div>");
				dispatcher.forward(request, response);

			} else if (log == true && status == 1) {

				if (request.getParameter("email") != null && request.getParameter("senha") != null) {
					session.setAttribute("email", "<div class='user-logged'><p>" + email + "</p></div>");
					daologin.SaveLogin(sessionID, 1, email);
					response.sendRedirect("painel.jsp");
				} else {
					daologin.SaveLogin("0", 0, email);
					session.removeAttribute("email");
					response.sendRedirect("index.jsp");
				}

			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
