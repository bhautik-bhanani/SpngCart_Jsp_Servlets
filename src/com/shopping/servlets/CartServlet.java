package com.shopping.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.doe.Product;
import com.shopping.doe.ProductImpl;
import com.shopping.doe.UserImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Product product = null;
		UserImpl users = null;
		String username = (String) request.getSession().getAttribute("username");
		if (username == null) {
			dispatcher = request.getRequestDispatcher("./login.jsp");
			dispatcher.forward(request, response);
		}
		if (request.getParameter("productId") != null) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			ProductImpl products = (ProductImpl) request.getSession().getAttribute("productBean");
			product = products.getProduct(productId);
			users = (UserImpl) request.getSession().getAttribute("userBean");
		}
		if (request.getParameter("type").equals("addtocart")) {
			users.addCartlist(username, product);
			dispatcher = request.getRequestDispatcher("./cart.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("addtowishlist")) {
			users.addWishlist(username, product);
			dispatcher = request.getRequestDispatcher("./wishlist.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("removecart")) {
			users.removeCartlist(username, product);
			dispatcher = request.getRequestDispatcher("./cart.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("removewishlist")) {
			users.removeWishlist(username, product);
			dispatcher = request.getRequestDispatcher("./wishlist.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("movetowishlist")) {
			users.moveCarttoWishLlist(username, product);
			dispatcher = request.getRequestDispatcher("./cart.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("movetocart")) {
			users.moveWishLlisttoCart(username, product);
			dispatcher = request.getRequestDispatcher("./wishlist.jsp");
			dispatcher.forward(request, response);
		} else if (request.getParameter("type").equals("logout")) {
			request.getSession().removeAttribute("username");
			dispatcher = request.getRequestDispatcher("./index.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (request.getParameter("type").equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserImpl users = (UserImpl) request.getSession().getAttribute("userBean");
			if (users.checkUser(username, password)) {
				request.getSession().setAttribute("username", username);
				dispatcher = request.getRequestDispatcher("./index.jsp");
				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("./login.jsp?error=true");
				dispatcher.forward(request, response);
			}
		}
	}
}
