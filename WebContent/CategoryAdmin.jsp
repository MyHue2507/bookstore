<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@page import="model.bean.CategoryBean"%>
<%@page import="model.bean.BookBean"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (request.getAttribute("ktthem") != null) {
			out.print("<script>alert('Không thêm được');</script>");
		}
	if (request.getAttribute("ktxoa") != null) {
		out.print("<script>alert('Không xóa được');</script>");
	}

	CategoryBean loai = (CategoryBean) request.getAttribute("chon");
	%>
	<form action="Admincontroller" method="post">
		<label>Mã loại: </label>
		<input type="text" name="txtmaLoai" value="<%= (loai==null ? "": loai.getIDCategory()) %>">
		<label>Tên loại: </label>
		<input type="text" name="txttenLoai" value="<%= (loai== null ?"" : loai.getName()) %>">
		<input type="submit" name="butthem" value="Thêm">
		<input type="submit" name="butsua" value="Sửa">
	</form>
	<%
		ArrayList<CategoryBean> categories = (ArrayList<CategoryBean>) request.getAttribute("dsloai");
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
                <a class="navbar-brand" href="HomeController">Admin</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- Page Content -->
    <div class="container">
	    <table>
		    <%
	        	for (CategoryBean categoryBean: categories) {
	        %>
		        <tr>
					<td> <%=categoryBean.getIDCategory() %> </td>
					<td> <%=categoryBean.getName() %> </td>
					<td>
						<a href="Admincontroller?mlchon=<%=categoryBean.getIDCategory()%>">
							Chọn
						</a>
					</td>
					<td>
						<a href="Admincontroller?mlxoa=<%=categoryBean.getIDCategory()%>">
							Xóa
						</a>
					</td>
				</tr>
			<%
				}
			%>
	    </table>
    </div>
    <!-- /.container -->
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer>
        </footer>
    </div>
    <!-- /.container -->
    <!-- jQuery -->
    <script src="/Scripts/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/Scripts/bootstrap.min.js"></script>
</body>
</html>