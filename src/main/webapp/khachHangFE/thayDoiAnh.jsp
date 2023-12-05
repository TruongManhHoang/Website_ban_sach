<%@page import="java.sql.Date"%>
<%@page import="model.khachhang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thông tin khách hàng</title>
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
<%String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()	;%>
<%
    String baoLoi = request.getAttribute("baoLoi")+"";
    baoLoi = (baoLoi.equals("null"))?"":baoLoi;

    Object obj = session.getAttribute("khachHang");
    khachhang kh = null;
    if(obj!=null){
    	kh = (khachhang)obj;
    }
    if(kh == null){
   %>
	 <div class="container"> 	
	   <p>Chưa đăng nhập</p>
	  </div>
 
    <% 
    }else{
    	String duongDanAnh = kh.getDuongDanAnh();
    	
%>
	
	<div class="container">
		<div class="text-center">
			<h1>Thông tin khách hàng</h1>
		</div>
		<div class="red" id="baoLoi">
			
		</div>
		<form class="form" action="<%=url %>/KhachhangController" method="post">
		    <input type="hidden" value="doiAnh" name="controller" id="doiAnh"/>
			<div class="row">
				<div class="col-sm-6">
					
					<h3>Thông tin khách hàng</h3>
					<img src="<%=url %>/khachHangFE/avatar/<%=duongDanAnh%>" alt="Ảnh Avatar"/>
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
	
	<%
	}
	%>
	
	<!-- footer -->
	<%@ include file="footer.jsp" %>
	<!-- end footer -->
</body>

<script>
	
	function xuLyChonDongY(){
		dongY = document.getElementById("dongY");
		if(dongY.checked==true){
			document.getElementById("submit").style.visibility="visible";
		} else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
</script>

</html>