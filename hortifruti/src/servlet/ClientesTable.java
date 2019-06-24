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

import bean.BeanClients;
import dao.DaoClients;
import dao.DaoLogin;


@WebServlet("/ClientesTable")
public class ClientesTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoLogin daologin = new DaoLogin();
	private DaoClients  daoclients = new DaoClients();

	public ClientesTable() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String action = request.getParameter("action");
			String user = request.getParameter("user");

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
					
					if(action != null && action.equalsIgnoreCase("ShowAll")) {
						RequestDispatcher view = request.getRequestDispatcher("/clientes.jsp");
						request.setAttribute("clientes", daoclients.listAll());
						view.forward(request, response);
						
					} else if(action != null && action.equalsIgnoreCase("delete")) {
						daoclients.delete(user);
						RequestDispatcher view = request.getRequestDispatcher("/clientes.jsp");
						request.setAttribute("clientes", daoclients.listAll());
						view.forward(request, response);
						
					} else if(action != null && action.equalsIgnoreCase("edit")) {
						BeanClients clientes = daoclients.edit(user);
						RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
						request.setAttribute("cli", clientes);
						view.forward(request, response);
					}else {
						RequestDispatcher view = request.getRequestDispatcher("/clientes.jsp");
						request.setAttribute("clientes", daoclients.listAll());
						view.forward(request, response);
					}
					
					
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
		
		String action = request.getParameter("action");
		
		if(action != null && action.equalsIgnoreCase("")) {
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientes.jsp");
		dispatcher.forward(request, response);
	}

}