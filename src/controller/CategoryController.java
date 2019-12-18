package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bo.BookBo;
import model.bo.CategoryBo;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBo bookBo = new BookBo();
    private CategoryBo categoryBo = new CategoryBo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
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
		
//		HttpSession session = request.getSession();
//		UserBean user = null;

//		// Check Login
//		if ((UserBean) session.getAttribute("user_shop_book") == null) {
//			RequestDispatcher rd = request.getRequestDispatcher("AuthController");
//			rd.forward(request, response);
//		}

		String idCategory = request.getParameter("idcategory");
		if (idCategory != null) {
			try {
				request.setAttribute("books", bookBo.getBooksByCategory(idCategory));
				request.setAttribute("categories", categoryBo.getCategories());
				request.setAttribute("category", categoryBo.getCategoryByID(idCategory));
				RequestDispatcher rd = request.getRequestDispatcher("Category.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
