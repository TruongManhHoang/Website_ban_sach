<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
</head>

<body>
<%
		Object obj = session.getAttribute("khachHang");
		khachhang khachHang = null;
		if (obj!=null)
			khachHang = (khachhang)obj;		
			if(khachHang==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}else {
				
	%>
	<div class="container">
	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
		
		String duongDanAnh= khachHang.getDuongDanAnh();
		
	%>
	<div class="container">
		<div class="text-center">
			<h1>THÔNG TIN TÀI KHOẢN</h1>
		</div>
		
		<div class="red" id="baoLoi">
			<%=baoLoi %>
		</div>
		<form class="form" action="<%=url1 %>/KhachhangController" method="post" enctype="multipart/form-data">
			<input type="hidden" name="controller" value="hello">
			<div class="row">
				<div class="col-sm-6">
					
					<h3>Thông tin khách hàng</h3>
					<img src="<%=url1 %>/khachHangFE/avatar/<%=duongDanAnh%>" alt="Ảnh Avatar"/>
					<div class="mb-3">
						<label for="duongDanAnh" class="form-label">Đường dẫn ảnh</label> <input
							type="file" class="form-control" id="duongDanAnh" name="duongDanAnh">
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" />
				</div>
			</div>
		</form>
	</div>
	</div>
	<%} %>
</body>
</html>