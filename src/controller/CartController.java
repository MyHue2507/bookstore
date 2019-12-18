package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BookBean;
import model.bean.Cart;
import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.bean.UserBean;
import model.bo.BookBo;
import model.bo.CartBo;
import model.bo.CategoryBo;
import model.bo.CustomerBo;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBo categoryBo = new CategoryBo();
	private CartBo cartBo = new CartBo();
	private BookBo bookBo = new BookBo();
	private CustomerBo customerBo = new CustomerBo();
	private UserBean user;
	private ArrayList<Cart> carts;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
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
		user = (UserBean) session.getAttribute("user_shop_book");

		// Check Login
		if (user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("AuthController");
			rd.forward(request, response);
		} else {
			carts = null;
			try {
				long idCustomer = customerBo.getCustomer(user.getUserName(), user.getPassword()).getIDCustomer();
				ArrayList<CartBean> cartBeans = cartBo.getCarts(idCustomer);
				for (CartBean cartB : cartBeans) {
					CartDetailBean cartDetail = cartBo.getCartDetail(cartB.getIDCart());
					BookBean book = bookBo.getBookByID(cartDetail.getIDBook());
					carts.add(new Cart(cartB, cartDetail, book));
				}
				request.setAttribute("categories", categoryBo.getCategories());
				request.setAttribute("carts", carts);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Gửi về client
			RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
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
