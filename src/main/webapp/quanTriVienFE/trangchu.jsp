<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bookstore</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
	
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>	
</head>
<body>







<div class="container-fluid">
<form action="dangnhapvadangkyquantrivien.jsp">


	<!-- header -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- end header -->
    
    
    
	<!-- Page content -->
	<div class="container mt-4">
		<div class="row">
			<!-- Menu left -->
			<div class="col-lg-3">
				<div class="list-group ">
					<a href="<%=url %>/sachFE/themSach.jsp" class="list-group-item list-group-item-action">
						Thêm sách thông tin sách </a> 
						<a href="<%=url %>/sachFE/chonSachDeSua.jsp"
						class="list-group-item list-group-item-action">Chỉnh sửa thông tin sách</a> <a
						href="/sachFE/xoaSach.jsp" class="list-group-item list-group-item-action">Xoá thông tin sách</a>
				</div>
			</div>
			<!-- End Menu left -->

			<!-- Slider and Products -->
			<div class="col-lg-9">
				<!-- Slider -->
				<div id="carouselExampleIndicators" class="carousel slide mb-4"
					data-bs-ride="true">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="<%=url %>/img/1.jpg" class="d-block w-75" alt="...">
						</div>
						<div class="carousel-item">
							<img src="<%=url %>/img/1.jpg" class="d-block w-75" alt="...">
						</div>
						<div class="carousel-item">
							<img src="<%=url %>/img/1.jpg" class="d-block w-75" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
				<!-- End Slider -->
				<!-- Products -->
				
				<!-- End Products -->
			</div>
			<!-- End Slider and Products -->
		</div>
	</div>
	<!-- End Page content -->

	<!-- footer -->
	<%@ include file="footer.jsp" %>
	<!-- end footer -->
	
</form>	
</div>
</body>
</html>