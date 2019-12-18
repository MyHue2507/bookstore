package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BookBean;
import model.bo.BookBo;
import model.bo.CategoryBo;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/ProductDetailController")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookBo bookBo = new BookBo();
	private CategoryBo categoryBo = new CategoryBo();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("idbook");
		if (id != null) {
			try {
				BookBean book = bookBo.getBookByID(id);
				request.setAttribute("book", book);
				request.setAttribute("categories", categoryBo.getCategories());
				RequestDispatcher rd = request.getRequestDispatcher("ProductDetail.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
