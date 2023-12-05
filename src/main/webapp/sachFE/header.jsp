<%@page import="model.quantrivien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.khachhang"%>  

<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()	;%>


<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="<%=url %>/img/Bold Green Neon Ninja Logo.png"
				alt="Bootstrap" height="50">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="<%=url%>/quanTriVienFE/trangchu.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
							<li><a class="dropdown-item" href="#">Áo thun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-3" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success me-3" type="submit">Tìm</button>
					
					<%
					    Object obj = session.getAttribute("quantrivien");
					    quantrivien qt = null;
					    if(obj != null){
					    	qt = (quantrivien)obj;
					    }
					    if(qt == null){
					%>    	
					    	<a class="btn btn-primary" style="white-space: nowrap;" href="<%=url %>/quanTriVienFE/dangNhapVaDangKy.jsp">Đăng nhập</a>
					<%
					    }else{	
					    	
					%>    	
					    <ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
								<li><a class="dropdown-item" href="#">Thông báo</a></li>
								<li><a class="dropdown-item" href="<%=url %>/quanTriVienFE/thayavatar.jsp">Thay avatar</a></li>
								<li><a class="dropdown-item" href="<%=url %>/quanTriVienFE/thongtinkhachhang.jsp">Thông
										tin khách hàng</a></li>
								<li><a class="dropdown-item" href="<%=url %>/quanTriVienFE/doimatkhau.jsp">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="<%=url %>/quanTriVienFE?controller=dangXuat">Đăng Xuất</a></li>
							</ul></li>
					    </ul>	
					<%				
					    }
					%>
				</form>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->