package quote.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import quote.model.Quote;
import user.dao.UserDAO;
import user.model.User;
import quote.dao.QuoteDAO;

/**
 * Servlet implementation class QuoteServlet
 */
@WebServlet("/")
public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private QuoteDAO quoteDAO;
	
	public void init() {
		quoteDAO = new QuoteDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/":
				showNewForm1(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/login":
				showlogin(request, response);
				break;
			case "/loginverif":
				verif(request, response);
				break;
			case "/insert":
				insertQuote(request, response);
				break;
			case "/delete":
				deleteQuote(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateQuote(request, response);
				break;
			case "/sortby":
				sortby(request, response);
				break;
			case "/userinsert":
				insertUser(request, response);
				break;
			case "/list":
				listQuote(request, response);
				break;
			case "/listquotes":
				listQuotes(request, response);
				break;
			case "/userlist":
				listUser(request, response);
				break;
			
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void sortby(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
		List<Quote> listQuote = quoteDAO.sortbywriter();
		request.setAttribute("listQuote", listQuote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listquotes.jsp");
		dispatcher.forward(request, response);
	}

	private void listQuote(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Quote> listQuote = quoteDAO.selectAllQuotes();
		request.setAttribute("listQuote", listQuote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("quote-list.jsp");
		dispatcher.forward(request, response);
	}
	private void listQuotes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Quote> listQuote = quoteDAO.selectAllQuotes();
		request.setAttribute("listQuote", listQuote);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listquotes.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("quote-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Quote existingQuote = quoteDAO.selectQuote(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("quote-form.jsp");
		request.setAttribute("quote", existingQuote);
		dispatcher.forward(request, response);

	}

	private void insertQuote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String contenu = request.getParameter("contenu");
		String auteur = request.getParameter("auteur");
		String source = request.getParameter("source");
		Quote newQuote = new Quote(contenu, auteur, source);
		quoteDAO.insertQuote(newQuote);
		response.sendRedirect("listquotes");
	}

	private void updateQuote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String contenu = request.getParameter("contenu");
		String auteur = request.getParameter("auteur");
		String source = request.getParameter("source");

		Quote b = new Quote(id, contenu, auteur, source);
		quoteDAO.updateQuote(b);
		response.sendRedirect("list");
	}

	private void deleteQuote(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		quoteDAO.deleteQuote(id);
		response.sendRedirect("list");

	}
	
	private void showNewForm1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showlogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		UserDAO userDAO =new UserDAO();
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void verif(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		UserDAO userDAO =new UserDAO();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User vUser = userDAO.selectUserbyEmail(email);
		System.out.println(email);
		if (vUser!=null) {
			if (email.equals("admin@gmail.com")) {
				 response.sendRedirect(request.getContextPath() + "/list");
			}
			else response.sendRedirect(request.getContextPath() + "/listquotes");
		}
			
		
		else {
			String message = "Please verify your data.";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
			dispatcher.forward(request, response);

	    
			
	}
	}
	
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User newUser = new User(name, email, password);
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(newUser);
		 response.sendRedirect(request.getContextPath() + "/listquotes");
	}
}
