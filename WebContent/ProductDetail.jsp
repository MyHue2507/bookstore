<%@page import="model.bean.UserBean"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>

<%@page import="model.bean.CategoryBean"%>
<%@page import="model.bean.BookBean"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title> Book Detail </title>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap Core CSS -->
    <link href="Content/bootstrap.css" rel="stylesheet" />

    <!-- Custom CSS -->
    <link href="Content/product_detail_page.css" rel="stylesheet" />
    <link href="Content/shop-homepage.css" rel="stylesheet" />

</head>
<body>
	
	<%
		ArrayList<CategoryBean> categories = (ArrayList<CategoryBean>) request.getAttribute("categories");
		BookBean book = (BookBean) request.getAttribute("book");
		UserBean user = (UserBean) session.getAttribute("user_shop_book");
	%>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="HomeController">BookStore</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="HomeController">Trang chủ</a>
                    </li>
                    <li>
                        <a href="#">Đăng ký</a>
                    </li>
                    <li>
                        <a href="AuthController">
                        	<%
                        		if(user != null) {
                        	%>
                        		<%=user.getUserName() %>
                        </a>
                    </li>
                    <li>
                        <a href="AuthController?logout=true">Đăng Xuất</a>
                    </li>
                        	<%
                        		} else {
                        	%>
                        		Đăng Nhập
                 		</a>
                    </li>
                        	<%
                        		}
                        	%>
                    <li>
                        <a href="#" style="color: white; font-weight: bold; text-decoration: none;">
                            Giỏ Hàng (0)
                        </a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    <!-- Page Content -->
    <div class="container">
        <div class="row">
        	
        	<!-- DANH MỤC SÁCH -->
            <div class="col-md-3">
                <p class="lead"> DANH MỤC SÁCH</p>
                <div class="list-group">
                	<%
                		if (categories != null) {
                			for(CategoryBean category: categories) {
	                %>
	                		<a href="CategoryController?idcategory=<%=category.getIDCategory() %>" class="list-group-item">
	                        	<%= category.getName() %>
	                    	</a>
	                <%
                			}
                		}
                	%>
                </div> 
            </div>
            
            <!-- MAIN -->
            <div class="col-md-9">
                <!-- BANNER -->
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="images/ancient-place.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/riverside-city.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="images/kayaks.jpg" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>
                </div>
                
                <!-- CHI TIẾT SÁCH -->
                <div>
                    <h3> THÔNG TIN CHI TIẾT SÁCH</h3>
                    <div>
                        <div class="image_product">
                            <img src="<%=book.getImage() %>">
                        </div>
                        <div class="info_product">
                            <h4> Tên sách: <span class="name_book" > <%=book.getName() %> </span> </h4>
                            <h4> Tác giả: <span class="author_name" > <%=book.getAuthor() %> </span> </h4>
                            <h4> Giá bán: <span class="number_price"> <%=book.getPriceFormat() %> </span> </h4>
                        </div>
                        <div>
                            <div class="cart_btn">
                                <a href="#" class="list-group-item">
                                    Đặt mua
                                </a>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
    <!-- /.container -->
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Java Advanced - 2019</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.container -->
    <!-- jQuery -->
    <script src="/Scripts/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/Scripts/bootstrap.min.js"></script>
</body>
</html>
