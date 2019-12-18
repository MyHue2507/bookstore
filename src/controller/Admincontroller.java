package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.CategoryBo;

/**
 * Servlet implementation class Admincontroller
 */
@WebServlet("/Admincontroller")
public class Admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private CategoryBo categoryBo = new CategoryBo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maLoai = request.getParameter("txtmaLoai");
			String tenLoai= request.getParameter("txttenLoai");
			
			if(request.getParameter("butthem")!=null) {
				int n = categoryBo.them(maLoai, tenLoai);
				if(n==0) request.setAttribute("ktthem", 0);
			}
			if(request.getParameter("butsua")!=null) {
				int n = categoryBo.sua(maLoai, tenLoai);
				if(n==0) request.setAttribute("ktsua", 0);
			}
			if(request.getParameter("mlchon")!=null) {
				request.setAttribute("chon", categoryBo.getLoai(request.getParameter("mlchon")));
			}
			if(request.getParameter("mlxoa")!=null) {
				int n= categoryBo.Xoa(request.getParameter("mlxoa"));
				if(n==0) request.setAttribute("ktxoa", 0);
			}
			request.setAttribute("dsloai", categoryBo.getCategories());
			
			RequestDispatcher rd = request.getRequestDispatcher("CategoryAdmin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
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
