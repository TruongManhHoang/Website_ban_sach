<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi Mật Khẩu</title>
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
	
<style>
.red {
	color: red;
}
</style>	
</head>
<body>

<!-- header -->
    <jsp:include page="header.jsp"></jsp:include>
<!-- end header -->

<%
    String baoLoi = request.getAttribute("baoLoi")+"";
    baoLoi = baoLoi.equals("null")?"":baoLoi;
    
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>



<%
    Object obj = session.getAttribute("khachHang");
    khachhang kh = null;
    if(obj != null){
    	kh = (khachhang)obj;
    }
    if(kh == null){
%>    	
    	<div class="container">
            <p>Chưa đăng nhập</p>
        </div>
<%         
    }else{
%>
	<div class="container">
		<form action="../KhachhangController" method="post">
		    <input type="hidden" value="doiMatKhau" name="controller" id="doiMatKhau"/>
			<div class="mb-3">
				<label for="matKhauCu" class="form-label">Mật Khẩu Cũ<span
					class="red">*</span></label> <input type="password" class="form-control"
					id="matKhauCu" name="matKhauCu" required="required">
			</div>
			<div class="mb-3">
				<label for="matKhauMoi" class="form-label">Mật Khẩu Mới<span
					class="red">*</span></label> <input type="password" class="form-control"
					id="matKhauMoi" name="matKhauMoi" required="required" onkeyup="kiemTraMatKhau()">
			</div>
			<div class="mb-3">
				<label for="matKhauMoiNhapLai" class="form-label">Nhập Lại
					Mật Khẩu Mới<span class="red">*</span>
				</label> <input type="password" class="form-control" id="matKhauMoiNhapLai"
					name="matKhauMoiNhapLai" required="required" onkeyup="kiemTraMatKhau()">
				<p id="msg" class="red"></p>	
			</div>

			<button type="submit" class="btn btn-primary">Đổi mật khẩu</button>
			
			<hr/>
			
			<a class="btn btn-primary" style="white-space: nowrap;" href= "<%=url %>/khachHangFE/trangchu.jsp" >Quay lại trang chủ</a>
			
			<hr/>
			
			<p class="red"><%=baoLoi %></p>
			
		</form>
	</div>
<% 
    }
%>

<!-- footer -->
	<%@ include file="footer.jsp" %>
	<!-- end footer -->
</body>

<script type="text/javascript">
function kiemTraMatKhau(){
	matKhau = document.getElementById("matKhauMoi").value;
	matKhauNhapLai = document.getElementById("matKhauMoiNhapLai").value;
	if(matKhau!=matKhauNhapLai){
		document.getElementById("msg").innerHTML = "Mật khẩu mới không khớp!";
		return false;
	}else{
		document.getElementById("msg").innerHTML = "";
		return true;
	}
}
</script>
</html>