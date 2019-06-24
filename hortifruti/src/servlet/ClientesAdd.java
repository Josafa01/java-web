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

@WebServlet("/ClientesAdd")
public class ClientesAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DaoLogin daologin = new DaoLogin();
	private DaoClients  daoclients = new DaoClients();

	public ClientesAdd() {
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
					RequestDispatcher dispatcher = request.getRequestDispatcher("clientes-add.jsp");
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
		
		try {
			
			String action = request.getParameter("action");
			String user = request.getParameter("user");
			
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String sobrenome = request.getParameter("sobrenome");
			String idade = request.getParameter("idade");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			String cidade = request.getParameter("cidade");
			String bairro = request.getParameter("bairro");
			String rua = request.getParameter("rua");
			
			for(int i = 0; i < idade.length(); i++) {
				Character c = idade.charAt(i);
				if(!Character.isDigit(c)) {
					if (!response.isCommitted()){
						  RequestDispatcher dispatcher = request.getRequestDispatcher("/clientes-add.jsp"); 
						  request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
								+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
								+ "    <strong>Campo Idade aceita somente Numeros!!</strong>" + "    </div>");
						 dispatcher.forward(request, response);
					}
					return;
				}
			}
			
			boolean save = true;
						
			if(nome == null || nome.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Nome vazio!!</strong>" + "    </div>");
				view.forward(request, response);
				 
			} else if(sobrenome == null || sobrenome.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Sobrenome vazio!!</strong>" + "    </div>");
				view.forward(request, response);
				 
			} else if(idade == null || idade.isEmpty() || idade == "0") {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Idade vazio!!</strong>" + "    </div>");
				view.forward(request, response);
				
			} else if(email == null || email.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Email vazio!!</strong>" + "    </div>");
				view.forward(request, response);
			} else if(telefone == null || telefone.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Telefone vazio!!</strong>" + "    </div>");
				view.forward(request, response);
			} else if(cidade == null || cidade.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Cidade vazio!!</strong>" + "    </div>");
				view.forward(request, response);
			} else if(bairro == null || bairro.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Bairro vazio!!</strong>" + "    </div>");
				view.forward(request, response);
			} else if(rua == null || rua.isEmpty()) {
				save = false;
				RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
				request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
						+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
						+ "    <strong>Campo Rua vazio!!</strong>" + "    </div>");
				view.forward(request, response);
			} else {
				try {
					if(!daoclients.verifyClient(nome, email) && save == false) {	
						RequestDispatcher view = request.getRequestDispatcher("/clientes-add.jsp");
						request.setAttribute("message", " <div class=\"alert alert-danger alert-dismissible fade show alert-style\">\n"
								+ "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n"
								+ "    <strong>Usuário já cadastrado!!</strong>" + "    </div>");
						view.forward(request, response);
						
					} else {
						
						BeanClients clientes = new BeanClients();
						clientes.setId((id != null && !id.isEmpty()) ? Long.parseLong(id) : null);
						clientes.setNome(nome);
						clientes.setSobrenome(sobrenome);
						clientes.setIdade((idade != null && !idade.isEmpty()) ? Integer.parseInt(idade) : null);
						clientes.setEmail(email);
						clientes.setTelefone(telefone);
						clientes.setCidade(cidade);
						clientes.setBairro(bairro);
						clientes.setRua(rua);
						
						if(id != null && !id.isEmpty() && save == true) {
							daoclients.update(clientes);
						} else {
							daoclients.insert(clientes);
						}
						
						
						RequestDispatcher view = request.getRequestDispatcher("/clientes.jsp");
						request.setAttribute("clientes", daoclients.listAll());
						view.forward(request, response);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
					

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
