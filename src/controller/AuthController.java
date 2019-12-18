package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.UserBean;
import model.bo.CategoryBo;
import model.bo.UserBo;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBo categoryBo = new CategoryBo();
	private UserBo userBo = new UserBo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Lấy dữ liệu từ client utf-8
		request.setCharacterEncoding("utf-8");
		// Gửi dữ liệu về client utf-8
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		// Check logout
		String isLogout = request.getParameter("logout");
		// Logout
		if (isLogout != null) {
			session.removeAttribute("user_shop_book");
		}
		
		// Get input
		String un = request.getParameter("user_name");
		String pw = request.getParameter("password");
		
		// Get session User
		UserBean userSession = (UserBean) session.getAttribute("user_shop_book");
		// Nếu đã login -> về Home
		if (userSession != null) {
			RequestDispatcher rd = request.getRequestDispatcher("HomeController");
			rd.forward(request, response);
		}
		
		UserBean user = null;
		try {
			// Lấy danh sách loại về gán vào biến categories
			request.setAttribute("categories", categoryBo.getCategories());
			// Check User DB
			if (un != null || pw != null) {
				user = userBo.getLogin(un, pw);
				
				if (user == null) {
					request.setAttribute("error", "error");
				}
			}
			// Set session User
			if (user != null) {
				session.setAttribute("user_shop_book", user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Kiểm tra User trong DB xong login -> lưu vô sesion
		// Nếu input sai. Kg có trong DB -> user = null
		if (user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("HomeController");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
